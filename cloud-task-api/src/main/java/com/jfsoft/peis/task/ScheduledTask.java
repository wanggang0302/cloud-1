package com.jfsoft.peis.task;

import com.jfsoft.utils.Constants;
import com.jfsoft.log.service.ITcLogService;
import com.jfsoft.task.entity.TcLog;
import com.jfsoft.task.service.ITaskService;
import com.jfsoft.task.service.ICloudFeignClient;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

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
    @Value("${hospital.name}")
    private String hospitalName;

    @Scheduled(cron = "${task.time}")
    public void execute() {
        logger.debug("现在时间是："+System.currentTimeMillis());
        try {

            TcLog tcLog = new TcLog();
            tcLog.setUpDate(new Date());

            //上传状态
            String status = "";

            if(type.equals("peis")) {
                logger.info("peis服务启动");
                status = taskService.getPerCheckInfoProc("001", rowlimit);
                tcLog.setUpType(Constants.UploadType.PEIS.getValue());
            } else if(type.equals("lis")) {
                logger.info("lis服务启动");
                status = taskService.getLisPatientInfoProc("001",rowlimit);
                tcLog.setUpType(Constants.UploadType.LIS.getValue());
            }

            logger.info("---------数据上传状态为--------" + status);
            tcLog.setUpStatus(
                    Short.parseShort(
                            !StringUtils.isBlank(status)?status:"0"));

            //医院编码和名称
            tcLog.setUpMechCode(hospitalCode);
            tcLog.setUpMechName(hospitalName);
            //保存日志
            tcLogService.save(tcLog);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
