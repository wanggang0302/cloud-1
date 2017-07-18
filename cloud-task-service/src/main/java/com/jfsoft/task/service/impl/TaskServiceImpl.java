package com.jfsoft.task.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jfsoft.task.entity.TcLisPatientinfo;
import com.jfsoft.task.entity.TcPerCheckinfo;
import com.jfsoft.task.mapper.LisMapper;
import com.jfsoft.task.mapper.PeisMapper;
import com.jfsoft.task.service.ICloudFeignClient;
import com.jfsoft.task.service.ITaskService;
import com.jfsoft.task.service.IWxFeignClient;
import com.jfsoft.utils.ZipCompressor;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

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

    @Autowired
    private IWxFeignClient wxFeignClient;

    @Value("${spring.application.name}")
    private String hospitalId;

    public String getPerCheckInfoProc(String areacode, String rowlimit) throws Exception {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("area_code", areacode);
        params.put("rowlimit", rowlimit);
        params.put("cur_arg_per", new ArrayList<TcPerCheckinfo>());
        peisMapper.getPerCheckinfoList(params);

        List<TcPerCheckinfo> perCheckinfoList = (List<TcPerCheckinfo>) params.get("cur_arg_per");

        String state = "";

        if(null!=perCheckinfoList && perCheckinfoList.size()>0) {
            for(TcPerCheckinfo tcPerCheckinfo : perCheckinfoList) {

                //获取本地zip流，上传
                FileInputStream fs = null;

                //zip文件地址
                String zipFileName = "";

                try {
                    //获得需要压缩的图片路径
                    String filePath = tcPerCheckinfo.getFilePath();
                    //生成zip文件到图片路径下
                    StringBuilder zipFileNameSb = new StringBuilder("");
                    zipFileNameSb.append(filePath).append("/");
                    zipFileNameSb.append(areacode).append("_");
                    zipFileNameSb.append(tcPerCheckinfo.getTestno()).append(".zip");

                    zipFileName = zipFileNameSb.toString();

                    //压缩到zip
                    ZipCompressor zc = new ZipCompressor(zipFileName);
                    zc.compressExe(filePath);

                    //获取本地zip流，上传
                    fs = new FileInputStream(zipFileName);

                    //获取文件名
                    File file = new File(zipFileName);
                    String picName = file.getName();

                    //上传
                    MockMultipartFile pic = new MockMultipartFile("file", picName, "", fs);
                    Map<String, Object> map = cloudFeignClient.uploadPic(pic);
                    //获取云端图片的路径
                    String cloudFilePath = (String) map.get("filePath");
                    //重新组装检验信息，更新filePath字段
                    tcPerCheckinfo.setFilePath(cloudFilePath);

                    String perCheckinfoJson = JSON.toJSONString(tcPerCheckinfo);

                    state = cloudFeignClient.peisSave(perCheckinfoJson);

                    String name = tcPerCheckinfo.getName();
                    Date date = tcPerCheckinfo.getTotalTime();
                    String tel = tcPerCheckinfo.getTel();

                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("hospitalId", hospitalId);
                    jsonObject.put("tel", tel);
                    jsonObject.put("name", name);
                    jsonObject.put("date", date);
                    jsonObject.put("itemValue", "体检报告单");
                    wxFeignClient.push(jsonObject.toJSONString());

                } catch (Exception e) {
                    logger.error("上传PEIS信息出错，error is {}。", e.getMessage());
                } finally {
                    if(null!=fs) fs.close();
                    File zipFile = new File(zipFileName);
                    if(null!=zipFile) {
                        zipFile.delete();
                    }
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
        lisMpper.getLisPatInfoList(params);

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

                String name = lisPatientinfo.getName();
                String feeName = lisPatientinfo.getFeename();
                Date date = lisPatientinfo.getTestdate();
                String tel = lisPatientinfo.getTel();

                //发送模板消息
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("hospitalId", hospitalId);
                jsonObject.put("tel", tel);
                jsonObject.put("name", name);
                jsonObject.put("date", date);
                jsonObject.put("itemValue", feeName + "报告单");
                wxFeignClient.push(jsonObject.toJSONString());
            }
        }

        return null;
    }

}
