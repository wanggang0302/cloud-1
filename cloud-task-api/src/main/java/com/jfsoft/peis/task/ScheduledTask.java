package com.jfsoft.peis.task;

import com.jfsoft.log.service.ITcLogService;
import com.jfsoft.task.service.ICloudFeignClient;
import com.jfsoft.task.service.ITaskService;
import com.jfsoft.task.service.downloader.ISaveDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 * wanggang
 * 2017-7-12 10:59:53
 */
@Component
@PropertySource(value = {"classpath:application.properties"}, encoding="utf-8")
public class ScheduledTask {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ITaskService taskService;

    @Autowired
    private ITcLogService tcLogService;

    @Autowired
    private ICloudFeignClient cloudFeignClient;

    @Autowired
    private ISaveDate saveDate;

    //每次上传条数
    @Value("${task.procedure.rowlimit}")
    private String rowlimit;

    //上传类型  lis或者peis
    @Value("${up.type}")
    private String type;

    //医院编码
    @Value("${spring.application.name}")
    private String hospitalCode;

    //医院名称
    //@Value("${hospital.name}")
    //private String hospitalName;

    /**
     * 上传检验结果
     */
    @Scheduled(cron = "${task.time.upResult}")
    public void upResult() {

        long beginProcess = System.currentTimeMillis();
        logger.debug("Start processing msg , type is :" + type + ".");

        try {
            taskService.processData(type);
            //TcLog tcLog = new TcLog();
            //tcLog.setUpDate(new Date());
            //
            ////上传状态
            //String status = "";

            //if(type.equalsIgnoreCase(Constants.UploadType.PEIS.getValue())) {
            //    logger.info("peis服务启动");
            //    status = taskService.getPerCheckInfoProc("001", rowlimit);
            //    tcLog.setUpType(Constants.UploadType.PEIS.getValue());
            //} else if(type.equalsIgnoreCase(Constants.UploadType.PEIS.getValue())) {
            //    logger.info("lis服务启动");
            //    status = taskService.getLisPatientInfoProc("001",rowlimit);
            //    tcLog.setUpType(Constants.UploadType.LIS.getValue());
            //} else {
            //    logger.error("没有与类型：" + type + " 相匹配的消息处理机制！");
            //}

            //logger.info("type is : " + type + ", 数据上传状态为--------" + status);
            //tcLog.setUpStatus(
            //        Short.parseShort(
            //                !StringUtils.isBlank(status)?status:"0"));
            //
            ////医院编码和名称
            //tcLog.setUpMechCode(hospitalCode);
            //tcLog.setUpMechName(hospitalName);
            ////保存日志
            //tcLogService.downloader(tcLog);
            //logger.debug("Type is : " + type + ", log is saved!");

            long endProcess = System.currentTimeMillis();
            logger.debug("End processing msg , type is :" + type + ", time used " + (endProcess-beginProcess) + " ms.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 保存已登记信息
     */
    @Scheduled(cron = "${task.time.downloader}")
    public void taskSaveInfo() {
        try {
            long beginProcess = System.currentTimeMillis();

            String info = cloudFeignClient.pullReg(hospitalCode);

            saveDate.saveRegInfo(info);

            long endProcess = System.currentTimeMillis();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
