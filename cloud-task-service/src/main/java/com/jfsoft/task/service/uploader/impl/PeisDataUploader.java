package com.jfsoft.task.service.uploader.impl;

import com.jfsoft.task.entity.TcPerCheckinfo;
import org.apache.commons.lang.StringUtils;

/**
 * 体检数据上传
 * wanggang
 * 2017-07-27 14:29
 */
public class PeisDataUploader extends DataUploader {

    protected <TcPerCheckinfo> boolean validate(TcPerCheckinfo perCheckinfo) {

        if(null!=perCheckinfo) {
            return true;
        }

        return false;
    }

    protected String getCloudFilePath() {
        return null;
    }

    protected String getUploadState() {
        return null;
    }

    protected void saveUploadLog() {

    }

    protected void callbackRpt() {

    }

}

