package com.jfsoft.task.service.process.impl;

import com.jfsoft.log.service.ITcLogService;
import com.jfsoft.task.entity.TcLog;
import com.jfsoft.task.service.ICloudFeignClient;
import com.jfsoft.task.service.process.ITaskDataProcess;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * 数据处理抽象类
 * wanggang
 * 2017-07-24 10:16
 */
public abstract class TaskDataProcess implements ITaskDataProcess {

    //日志
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    protected ITcLogService tcLogService;

    //医院编码
    @Value("${spring.application.name}")
    protected String hospitalCode;

    protected String hospitalId;
    protected String rowlimit;

    //上传失败的日志记录key：记录ID；value：失败次数
    protected Map<String, Long> uploadFailureLog;

    //云平台
    @Autowired
    protected ICloudFeignClient cloudFeignClient;

    public void uploadData(String hospitalId, String rowlimit) throws Exception {

        this.hospitalId = hospitalId;
        this.rowlimit = rowlimit;

        //查询数据上传日志
        uploadFailureLog = selectUploadLog();

        //数据处理并上传，返回上传状态
        handleData();

        //
    }

    //查询上传日志
    protected abstract Map<String, Long> selectUploadLog() throws Exception;

    //处理数据
    protected abstract void handleData() throws Exception;

    //

    protected void saveUploadLog(String dataId, String type, String status, String statusInfo) throws Exception {

        TcLog tcLog = new TcLog();
        tcLog.setId(UUID.randomUUID().toString());
        tcLog.setUpDataId(dataId);
        tcLog.setUpType(type);
        tcLog.setUpDate(new Date());
        tcLog.setUpStatus(status);
        tcLog.setUpStatusInfo(statusInfo);

        //医院编码和名称
        //tcLog.setUpMechCode(hospitalCode);
        //tcLog.setUpMechName(hospitalName);
        //保存日志
        tcLogService.save(tcLog);
        logger.debug("Type named " + type + ", log is saved!");
    }

}
