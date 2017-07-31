package com.jfsoft.cloud;

import com.alibaba.fastjson.JSON;
import com.jfsoft.cloud.entity.TcLisPatientinfo;
import com.jfsoft.cloud.entity.TcPerCheckinfo;
import com.jfsoft.cloud.service.IPeisService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by web on 2017/6/28.
 */
@RestController
@RequestMapping(value = "/cloud")
public class CloudController {

    private static Logger logger = Logger.getLogger(CloudController.class);

    @Autowired
    private IPeisService peisService;

    @Value("${picPath}")
    private String picPath;

    /**
     * spring cloud测试
     */
    @Value("${server.port}")
    String port;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String home(@RequestParam String name) {
        return "hi "+name+",i am from port:" +port;
    }


    /**
     * 体检人员信息保存接口
     * @param
     * @return
     */
    @PostMapping(value = "/peisSave")
    public HttpEntity peisSave(String info){
        TcPerCheckinfo tcPerCheckinfo = JSON.parseObject(info, TcPerCheckinfo.class);
        tcPerCheckinfo.setPerinfo(info);
        int i = peisService.insertPeisPercheckinfo(tcPerCheckinfo);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    /**
     * 接收LIS报告单图片
     * @param file
     * @return
     */
    @PostMapping(value = "/uploadPic")
    public HttpEntity uploadPic(MultipartFile file) {
        Map<String, Object> map = new HashMap<String, Object>();
        //判断文件是否为空
        if (!file.isEmpty()) {
            try {
                File files = new File(picPath);
                if(!files.exists()){
                    files.mkdirs();
                }
                //文件保存路径
                String filePath = picPath+"/"+file.getOriginalFilename();
                map.put("filePath",filePath);
                //转存文件
                file.transferTo(new File(filePath));
                map.put("state","保存成功");
            } catch (Exception e) {
                map.put("state","保存失败");
                e.printStackTrace();
            }
        }
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    /**
     * 检验人员信息保存接口
     * @param
     * @return
     */
    @PostMapping(value = "/lisSave")
    public HttpEntity lisSave(String info){
        TcLisPatientinfo tcLisPatientinfo = JSON.parseObject(info, TcLisPatientinfo.class);
        String pic = tcLisPatientinfo.getPic();
        //System.out.println(pic);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

}
