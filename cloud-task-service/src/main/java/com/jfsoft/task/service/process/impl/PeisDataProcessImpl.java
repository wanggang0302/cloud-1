package com.jfsoft.task.service.process.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jfsoft.task.entity.TcPerCheckinfo;
import com.jfsoft.task.mapper.PeisMapper;
import com.jfsoft.utils.Constants;
import com.jfsoft.utils.FileUtil;
import com.jfsoft.utils.ZipCompressor;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Peis(体检)数据处理
 * 1.调用存储过程A，根据区域编码areacode和查询的条数限制rowlimit（二者可配）查询体检人员信息
 * 2.处理体检者的体检报告单（
 *      报告单是图片，存储在物理磁盘中，文件夹以体检号：5001的格式命名；
 *      报告单图片以体检号+顺序号:5001.1.jpg、5001.2.jpg...的格式命名）,
 *   将图片压缩，命名为“区域编码+体检号.zip”的格式：001_5001.zip.
 * 3.将体检报告单的zip上传到云端，获取云端返回的图片路径
 * 4.将云端返回的报告单图片路径保存到云端体检者的filePath字段中，上传体检者信息到云平台
 * 5.云平台返回体检者信息的上传状态
 * 6.截止到步骤5成功执行，并且步骤5返回的上传状态是成功，执行步骤8
 * 7.如果3、4、5步骤中任何一个环节失败，表示此条数据上传失败：如果失败次数在100次以内，在日志表中记录一条失败日志；
 *   如果超过100次，执行步骤8
 * 8.执行存储过程B，存储过程B是为了保证存储过程A执行的时候，不再查询到已经上传的数据。
 *
 * 9.如果前置机查询到此条数据是要删除的数据
 * 10.上传数据时，要记录此条数据图片附件的大小，传递到云平台进行验证
 *
 * wanggang
 * 2017-07-24 10:15
 */
@Service
public class PeisDataProcessImpl extends TaskDataProcess {

    //日志
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PeisMapper peisMapper;

    protected Map<String, Long> selectUploadLog() throws Exception {

        return tcLogService.selectUploadFailureLog(Constants.UploadType.PEIS.getValue());
    }

    public void handleData() throws Exception {

        //获得要上传的数据
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
        params.put("rowlimit", rowlimit);
        List<TcPerCheckinfo> perCheckinfoList = peisMapper.getPerCheckinfoList(params);

        return perCheckinfoList;
    }

    public void handleData(TcPerCheckinfo tcPerCheckinfo) throws Exception {

        //获取本地zip流，上传
        FileInputStream fs = null;

        //zip文件地址
        String zipFileName = "";

        //数据上传到云平台的状态
        String status = "";

        //获得需要压缩的图片路径
        String filePath = tcPerCheckinfo.getFilePath();
        //生成zip文件到图片路径下
        File imgFilePath = new File(filePath);
        String parentFilePath = imgFilePath.getParentFile().getPath();

        //获取数据唯一标识
        int id = tcPerCheckinfo.getId();
        String testno = tcPerCheckinfo.getTestno();

        if(!StringUtils.isBlank(filePath)) {

            try {

                //删除上传目录中的zip文件
                FileUtil.deleteFilesByType(parentFilePath, Constants.FILE_TYPE_ZIP);
            } catch (Exception e) {
                logger.error("Delete zip file from upload path fail, err msg is : " + e.getMessage());
                e.printStackTrace();
            }

            //获取云端图片的路径
            String cloudFilePath = "";
            //获取文件大小(字节B)，云平台验证附件上传完整度
            long picSize = 0l;

            try {

                //将zip文件生成到父级文件夹中
                StringBuilder zipFileNameSb = new StringBuilder("");
                zipFileNameSb.append(parentFilePath).append("/");
                zipFileNameSb.append(hospitalId).append("_");
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
                //获取文件大小(字节B)，云平台验证附件上传完整度
                picSize = file.length();

                //上传
                MockMultipartFile pic = new MockMultipartFile("file", picName, "", fs);
                String result = cloudFeignClient.uploadPic(pic, picSize);
                logger.debug("Upload pic success!");

                //获取云端图片的路径
                JSONObject jsonObject = JSON.parseObject(result);
                //获取云端图片的路径
                cloudFilePath = jsonObject.getString("filePath");

            } catch (Exception e) {
                logger.error("PEIS image uploading error，err msg is {}。", e.getMessage());
                e.printStackTrace();
            } finally {
                if(null!=fs) fs.close();
                File zipFile = new File(zipFileName);
                if(null!=zipFile) {
                    zipFile.delete();
                }
            }

            try {

                //重新组装检验信息，更新filePath字段
                tcPerCheckinfo.setFilePath(cloudFilePath);
                tcPerCheckinfo.setFileSize(picSize);
                tcPerCheckinfo.setHospitalCode(hospitalCode);

                //wanggang 2017年8月1日13:44:29
                tcPerCheckinfo.setId(null);

                String perCheckinfoJson = JSON.toJSONString(tcPerCheckinfo);
                //上传数据到云平台
                String statusJson = cloudFeignClient.peisSave(perCheckinfoJson);

                //获得数据上传状态
                JSONObject statusJsonObject = JSONObject.parseObject(statusJson);
                status = statusJsonObject.get(Constants.UPLOAD_STATUS_KEY).toString();

                logger.info("PEIS data uploading status is " + status);
            } catch (Exception e) {
                status = Constants.UploadStatus.FAILURE.getValue();
                logger.error("PEIS data uploading error，err msg is {}。", e.getMessage());
                e.printStackTrace();
            }
        } else {
            status = Constants.UploadStatus.FAILURE.getValue();
        }

        postProcessAfterHandleData(testno, tcPerCheckinfo.getTotalTime(), status);
    }

    /**
     * 数据后处理
     * @param id 数据唯一标识
     * @param status 数据处理状态
     * @throws Exception
     */
    private void postProcessAfterHandleData(String id, Date totalTime, String status) throws Exception {

        long count = 0l;
        if(null!=uploadFailureLog&&uploadFailureLog.size()>0&&null!=uploadFailureLog.get(id)) {
            count = uploadFailureLog.get(id);
        }
        //如果上传失败，查询历史失败次数
        if(Constants.UploadStatus.SUCCESS.getValue().equals(status) || (count>=100)) {
            //如果数据上传成功或者数据上传失败超过一定次数，需要调用存储过程，确保下次执行不再查询到此条记录
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("id", id);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            params.put("totalTime", null!=totalTime?sdf.format(totalTime):"");
            peisMapper.updatePerCheckinfoState(params);
        }

        //保存上传信息到日志表
        saveUploadLog(id, Constants.UploadType.PEIS.getValue(), status, "");
    }

}
