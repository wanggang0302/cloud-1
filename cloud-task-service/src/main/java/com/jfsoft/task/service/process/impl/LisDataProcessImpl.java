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

    protected Map<String, Long> selectUploadLog() throws Exception {

        return tcLogService.selectUploadFailureLog(Constants.UploadType.PEIS.getValue());
    }

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

        Integer patinfoid = null;

        String state = "";

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
            logger.debug("Lis upload pic success!");

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
            logger.debug("Save lis info success!");

            JSONObject json = JSON.parseObject(data);
            patinfoid = lisPatientinfo.getPatinfoid();
            state = json.getString("status");
            //调用插入patinfoid存储过程
            logger.info("LIS data, 数据上传状态为--------" + state);
            //Integer i = lisMpper.insertTag(patinfoid);
            //saveUploadLog(Constants.UploadType.PEIS.getValue(), state);
        } catch (Exception e) {
            logger.error("Upload LIS img fail, err msg is {}.", e.getMessage());
            e.printStackTrace();
        }

        postProcessAfterHandleData(patinfoid, state);
    }

    /**
     * 数据后处理
     * @param id 数据唯一标识
     * @param status 数据处理状态
     * @throws Exception
     */
    private void postProcessAfterHandleData(Integer id, String status) throws Exception {

        long count = null!=uploadFailureLog&&uploadFailureLog.containsKey(id)?uploadFailureLog.get(id):0l;
        //如果上传失败，查询历史失败次数
        if(Constants.UploadStatus.SUCCESS.getValue().equals(null!=status?status.toUpperCase():"") || (count>=100)) {
            //如果数据上传成功或者数据上传失败超过一定次数，需要调用存储过程，确保下次执行不再查询到此条记录
            lisMpper.insertTag(id);
        }
        //保存上传信息到日志表
        saveUploadLog(id.toString(), Constants.UploadType.LIS.getValue(), status, "");
    }

}
