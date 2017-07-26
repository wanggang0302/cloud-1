package com.jfsoft.task.service.process.impl;

import com.jfsoft.log.service.ITcLogService;
import com.jfsoft.task.entity.TcLog;
import com.jfsoft.task.service.ICloudFeignClient;
import com.jfsoft.task.service.process.ITaskDataProcess;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * 数据处理抽象类
 * wanggang
 * 2017-07-24 10:16
 */
public abstract class TaskDataProcess implements ITaskDataProcess {

    //日志
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ITcLogService tcLogService;

    protected String areacode;
    protected String rowlimit;

    //云平台
    @Autowired
    protected ICloudFeignClient cloudFeignClient;

    public void uploadData(String areacode, String rowlimit) throws Exception {

        this.areacode = areacode;
        this.rowlimit = rowlimit;

        //数据处理并上传，返回上传状态
        handleData();
    }

    protected abstract void handleData() throws Exception;

    protected void saveUploadLog(String type, String state) throws Exception {

        TcLog tcLog = new TcLog();
        tcLog.setUpDate(new Date());

        tcLog.setUpStatus(
                Short.parseShort(
                        !StringUtils.isBlank(state)?state:"0"));

        //医院编码和名称
        //tcLog.setUpMechCode(hospitalCode);
        //tcLog.setUpMechName(hospitalName);
        //保存日志
        tcLogService.save(tcLog);
        logger.debug("Type is : " + type + ", log is saved!");
    }

}
