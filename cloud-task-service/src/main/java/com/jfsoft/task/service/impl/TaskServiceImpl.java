package com.jfsoft.task.service.impl;

import com.alibaba.fastjson.JSON;
import com.jfsoft.task.entity.TcLisPatientinfo;
import com.jfsoft.task.entity.TcPerCheckinfo;
import com.jfsoft.task.mapper.LisMapper;
import com.jfsoft.task.mapper.PeisMapper;
import com.jfsoft.task.service.ICloudFeignClient;
import com.jfsoft.task.service.ITaskService;
import com.jfsoft.utils.ZipCompressor;
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
 * 定时任务业务实现类
 * wanggang
 * 2017-7-11 13:36:06
 */
@Service
public class TaskServiceImpl implements ITaskService {

    //日志
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PeisMapper peisMapper;

    @Autowired
    private LisMapper lisMpper;

    @Autowired
    private ICloudFeignClient cloudFeignClient;

    public String getPerCheckInfoProc(String areacode, String localFileDir, String rowlimit) throws Exception {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("area_code", areacode);
        params.put("rowlimit", rowlimit);
        params.put("cur_arg_per", new ArrayList<TcPerCheckinfo>());
        peisMapper.getPerCheckinfoList(params);

        List<TcPerCheckinfo> perCheckinfoList = (List<TcPerCheckinfo>) params.get("cur_arg_per");

        String state = "";

        if(null!=perCheckinfoList && perCheckinfoList.size()>0) {
            for(TcPerCheckinfo tcPerCheckinfo : perCheckinfoList) {

                //获得需要压缩的图片路径
                String filePath = tcPerCheckinfo.getFilePath();
                //生成的zip文件路径
                StringBuilder zipFileNameSb = new StringBuilder(localFileDir);
                zipFileNameSb.append(areacode).append("_");
                zipFileNameSb.append(tcPerCheckinfo.getTestno()).append(".zip");

                String zipFileName = zipFileNameSb.toString();

                //压缩到zip
                ZipCompressor zc = new ZipCompressor(zipFileName);
                zc.compressExe(filePath);

                //获取本地zip流，上传
                FileInputStream fs =new FileInputStream(zipFileName);

                //获取文件名
                File file = new File(zipFileName);
                String picName = file.getName();

                MockMultipartFile pic = new MockMultipartFile("file",picName,"",fs);
                Map<String, Object> map = new HashMap<String, Object>();
                //上传
                map = cloudFeignClient.uploadPic(pic);
                //获取云端图片的路径
                String cloudFilePath = (String) map.get("filePath");
                //重新组装检验信息，更新filePath字段
                tcPerCheckinfo.setFilePath(cloudFilePath);

                String perCheckinfoJson = JSON.toJSONString(tcPerCheckinfo);
                state = cloudFeignClient.peisSave(perCheckinfoJson);
                if(state.equals("OK")){
                    String testno = tcPerCheckinfo.getTestno();
                    peisMapper.saveTag_Id(testno);
                }
            }
        }

        return state;
    }

    public String getLisPatientInfoProc(String areacode, String rowlimit) throws Exception {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("area_code", areacode);
        params.put("rowlimit", rowlimit);
        params.put("cur_arg_per", new ArrayList<TcPerCheckinfo>());
        lisMpper.getLisPatientInfoList(params);
        List<TcLisPatientinfo> lisPatientinfoList = (List<TcLisPatientinfo>) params.get("cur_arg_per");
        String state = "";
        if(null!=lisPatientinfoList && lisPatientinfoList.size()>0){
            for(TcLisPatientinfo lisPatientinfo : lisPatientinfoList){
                //生成json
                String lisPatientinfoJson = JSON.toJSONString(lisPatientinfo);
                TcLisPatientinfo tcLisPatientinfo = JSON.parseObject(lisPatientinfoJson, TcLisPatientinfo.class);

                //从LIS表中获取filepath
                String filePath = tcLisPatientinfo.getFilepath();

                //获取本地图片流，上传
                FileInputStream fs =new FileInputStream(filePath);

                //获取文件名
                File file = new File(filePath);
                String picName = file.getName();

                MockMultipartFile pic = new MockMultipartFile("file",picName,"",fs);
                Map<String, Object> map = new HashMap<String, Object>();
                //上传
                map = cloudFeignClient.uploadPic(pic);
                //获取云端图片的路径
                String cloudFilePath = (String) map.get("filePath");
                //重新组装检验信息，更新filePath字段
                tcLisPatientinfo.setFilepath(cloudFilePath);
                //调用lisSave接口，发送重新组装的消息
                //String tcLisPatientinfo = JSON.toJSONString(tcLisPatientinfo);
                //cloudFeignClient.lisSave();
                /*if(state.equals("OK")){
                    String testno = tcPerCheckinfo.getTestno();
                    peisMapper.saveTag_Id(testno);
                }*/
            }
        }

        return null;
    }

}
