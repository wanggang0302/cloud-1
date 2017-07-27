package com.jfsoft.task.service.uploader.impl;

import com.jfsoft.task.service.uploader.IDataUploader;

/**
 * 数据上传
 * wanggang
 * 2017-07-27 14:07
 */
public abstract class DataUploader implements IDataUploader {

    public <T> T uploadData(Class<T> t) {

        //校验数据格式（是否上传）
        boolean isValid = validate(t);

        if(isValid) {

            //上传图片
            String cloudFilePath = getCloudFilePath();

            //上传数据
            String cloudUploadState = getUploadState();

            //保存日志
            saveUploadLog();

        } else {

            //调用存储过程
            callbackRpt();
        }

        T instance = null;

        try {
            instance = t.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return instance;
    }

    protected abstract <T> boolean validate(T t);

    protected abstract String getCloudFilePath();

    protected abstract String getUploadState();

    protected abstract void saveUploadLog();

    protected abstract void callbackRpt();

}
