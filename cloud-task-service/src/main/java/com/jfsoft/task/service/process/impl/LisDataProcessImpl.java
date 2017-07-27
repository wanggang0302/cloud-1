package com.jfsoft.task.service.process.impl;

import com.alibaba.fastjson.JSON;
import com.jfsoft.task.entity.TcLisPatientinfo;
import com.jfsoft.task.entity.TcPerCheckinfo;
import com.jfsoft.task.mapper.LisMapper;
import com.jfsoft.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
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
        params.put("area_code", areacode);
        params.put("rowlimit", rowlimit);
        params.put("cur_arg_per", new ArrayList<TcPerCheckinfo>());
        lisMpper.getLisPatInfoList(params);

        List<TcLisPatientinfo> lisPatientinfoList = (List<TcLisPatientinfo>) params.get("cur_arg_per");

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

            MockMultipartFile pic = new MockMultipartFile("file", picName, "", fs);

            //上传
            map = cloudFeignClient.uploadPic(pic);
        } catch (Exception e) {
            logger.error("Upload LIS img fail, err msg is {}.", e.getMessage());
            e.printStackTrace();
        }
        //获取云端图片的路径
        String cloudFilePath = (String) map.get("filePath");
        //重新组装检验信息，更新filePath字段
        lisPatientinfo.setFilepath(cloudFilePath);
        //调用lisSave接口，发送重新组装的消息
        String lisPatientinfoJson = JSON.toJSONString(lisPatientinfo);
        String state = cloudFeignClient.lisSave(lisPatientinfoJson);

        logger.info("LIS data, 数据上传状态为--------" + state);

        saveUploadLog(Constants.UploadType.PEIS.getValue(), state);
    }

}
