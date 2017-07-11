package com.jfsoft.peis.task;

import com.jfsoft.utils.Constants;
import com.jfsoft.log.service.ITcLogService;
import com.jfsoft.task.entity.TcLog;
import com.jfsoft.task.service.ITaskService;
import com.jfsoft.task.service.ICloudFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by web on 2017/6/29.
 */
@Component
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

    //图片本地路径
    @Value("${local.filedir}")
    private String localFileDir;

    @Scheduled(cron = "${task.time}")
    public void execute() {
        logger.debug("现在时间是："+System.currentTimeMillis());
        try {

            TcLog tcLog = new TcLog();
            tcLog.setUpDate(new Date());

            //上传状态
            String status = "";

            if(type.equals("peis")) {
                status = taskService.getPerCheckInfoProc("001", localFileDir, rowlimit);
                tcLog.setUpType(Constants.UploadType.PEIS.toString());
            }else if(type.equals("lis")){
                logger.info("lis服务启动");
                status = taskService.getLisPatientInfoProc("001",rowlimit);
                tcLog.setUpType(Constants.UploadType.LIS.toString());
            }

            logger.info("---------数据上传状态为--------" + status);
            tcLog.setUpStatus(Short.parseShort(status));

            //保存日志
            tcLogService.save(tcLog);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
