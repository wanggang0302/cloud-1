package com.jfsoft.task.service.process.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jfsoft.task.entity.TcPerCheckinfo;
import com.jfsoft.task.mapper.PeisMapper;
import com.jfsoft.utils.Constants;
import com.jfsoft.utils.FileUtil;
import com.jfsoft.utils.ZipCompressor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

/**
 * Peis(体检)数据处理
 * 1.调用存储过程，根据区域编码areacode和查询的条数限制rowlimit（二者可配）查询体检人员信息
 * 2.处理体检者的体检报告单（
 *      报告单是图片，存储在物理磁盘中，文件夹以区域编码+体检号：001_5001的格式命名；
 *      报告单图片以体检号+顺序号:5001_1、5001_2...的格式命名）,
 *   将图片压缩，命名为“区域编码+体检号.zip”的格式：001_5001.zip.
 * 3.将体检报告单的zip上传到云端，获取云端返回的图片路径
 * 4.将云端返回的报告单图片路径保存到云端体检者的filePath字段中，上传体检者信息到云平台
 * 5.云平台返回体检者信息的上传状态，前置机程序保存上传状态
 * wanggang
 * 2017-07-24 10:15
 */
@Service
public class PeisDataProcessImpl extends TaskDataProcess {

    //日志
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PeisMapper peisMapper;

    public void handleData() throws Exception {

        List<TcPerCheckinfo> perCheckinfoList = getPerCheckinfoData();

        if(null!=perCheckinfoList && perCheckinfoList.size()>0) {
            for(TcPerCheckinfo tcPerCheckinfo : perCheckinfoList) {

                handleData(tcPerCheckinfo);
            }
        }
    }

    private List<TcPerCheckinfo> getPerCheckinfoData() throws Exception {

        //调用存储过程，查询体检者信息
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("area_code", areacode);
        params.put("rowlimit", rowlimit);
        params.put("cur_arg_per", new ArrayList<TcPerCheckinfo>());
        peisMapper.getPerCheckinfoList(params);

        List<TcPerCheckinfo> perCheckinfoList = (List<TcPerCheckinfo>) params.get("cur_arg_per");

        return perCheckinfoList;
    }

    public void handleData(TcPerCheckinfo tcPerCheckinfo) throws Exception {

        //获取本地zip流，上传
        FileInputStream fs = null;

        //zip文件地址
        String zipFileName = "";

        //获得需要压缩的图片路径
        String filePath = tcPerCheckinfo.getFilePath();

        try {

            //删除上传目录中的zip文件
            FileUtil.deleteFilesByType(filePath, Constants.FILE_TYPE_ZIP);
        } catch (Exception e) {
            logger.error("Delete zip file from upload path fail, err msg is : " + e.getMessage());
            e.printStackTrace();
        }
        try {
            //生成zip文件到图片路径下
            StringBuilder zipFileNameSb = new StringBuilder("");
            zipFileNameSb.append(filePath).append("/");
            zipFileNameSb.append(areacode).append("_");
            zipFileNameSb.append(tcPerCheckinfo.getTestno()).append(".zip");
            //生成的压缩文件地址：体检报告单路径/区域编码_体检号.zip
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
            //上传数据到云平台
            String state = cloudFeignClient.peisSave(perCheckinfoJson);

            logger.info("PEIS data, 数据上传状态为--------" + state);

            saveUploadLog(Constants.UploadType.PEIS.getValue(), state);
        } catch (Exception e) {
            logger.error("PEIS data uploading error，err msg is {}。", e.getMessage());
            e.printStackTrace();
        } finally {
            if(null!=fs) fs.close();
            File zipFile = new File(zipFileName);
            if(null!=zipFile) {
                zipFile.delete();
            }
        }
    }

}
