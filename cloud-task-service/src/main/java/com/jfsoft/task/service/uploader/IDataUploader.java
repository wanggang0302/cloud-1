package com.jfsoft.task.service.uploader;

/**
 * 数据上传接口
 * wanggang
 * 2017-07-27 14:07
 */
public interface IDataUploader {

    public <T> T uploadData(Class<T> t);

}
