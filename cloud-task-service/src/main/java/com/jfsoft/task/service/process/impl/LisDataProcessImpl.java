package com.jfsoft.task.service.process.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jfsoft.task.entity.TcLisPatientinfo;
import com.jfsoft.task.mapper.LisMapper;
import com.jfsoft.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * wanggang
 * 2017-07-24 13:17
 */
@Service
public class LisDataProcessImpl extends TaskDataProcess {

    //日志
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private LisMapper lisMpper;

    @Value("${spring.application.name}")
    private String hospital_code;

    protected void handleData() throws Exception {

        List<TcLisPatientinfo> lisPatientinfoList = getLisPatientinfoData();

        if(null!=lisPatientinfoList && lisPatientinfoList.size()>0){
            for(TcLisPatientinfo lisPatientinfo : lisPatientinfoList){
                handleData(lisPatientinfo);
            }
        }
    }

    private List<TcLisPatientinfo> getLisPatientinfoData() {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("rowlimit", rowlimit);

        List<TcLisPatientinfo> lisPatientinfoList = lisMpper.getLisPatInfoList(params);

        return lisPatientinfoList;
    }

    /**
     * 处理Lis人员信息
     * @param lisPatientinfo
     * @throws Exception
     */
    private void handleData(TcLisPatientinfo lisPatientinfo) throws Exception {

        Map<String, Object> map = new HashMap<String, Object>();
        try {
            //从LIS表中获取filepath
            String filePath = lisPatientinfo.getFilepath();

            //获取本地图片流，上传
            FileInputStream fs = new FileInputStream(filePath);

            //获取文件名
            File file = new File(filePath);
            String picName = file.getName();
            Long picSize = file.length();
            MockMultipartFile pic = new MockMultipartFile("file", picName, "", fs);

            //上传
            String result = cloudFeignClient.uploadPic(pic, picSize);
            JSONObject jsonObject = JSON.parseObject(result);
            //获取云端图片的路径
            String cloudFilePath = jsonObject.getString("filePath");
            //重新组装检验信息，更新filePath字段
            lisPatientinfo.setFilepath(cloudFilePath);
            lisPatientinfo.setHospitalCode(hospital_code);
            lisPatientinfo.setLisinfo(JSON.toJSONString(lisPatientinfo));
            //调用lisSave接口，发送重新组装的消息
            String lisPatientinfoJson = JSON.toJSONString(lisPatientinfo);
            String data = cloudFeignClient.lisSave(lisPatientinfoJson);
            JSONObject json = JSON.parseObject(data);
            Integer patinfoid = json.getInteger("data");
            String state = json.getString("status");
            //调用插入patinfoid存储过程
            Integer i = lisMpper.insertTag(patinfoid);
            logger.info("LIS data, 数据上传状态为--------" + state);
            saveUploadLog(Constants.UploadType.PEIS.getValue(), state);
        } catch (Exception e) {
            logger.error("Upload LIS img fail, err msg is {}.", e.getMessage());
            e.printStackTrace();
        }

    }

}
