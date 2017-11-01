package com.jfsoft.peis.task;

import com.alibaba.fastjson.JSON;
import com.jfsoft.log.service.ITcLogService;
import com.jfsoft.task.entity.RegPatientinfo;
import com.jfsoft.task.service.ICloudFeignClient;
import com.jfsoft.task.service.ITaskService;
import com.jfsoft.task.service.downloader.ISaveDate;
import com.jfsoft.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

            if(type.equalsIgnoreCase(Constants.UploadType.LIS.toString())) {

                String info = cloudFeignClient.pullReg(hospitalCode);

                saveDate.saveRegInfo(info);
            }
            long endProcess = System.currentTimeMillis();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//
//    /**
//     * 更新标本状态
//     */
//    @Scheduled(cron = "${task.time.updateState}")
//    public void taskupdateState() {
//        try {
//
//            if(type.equalsIgnoreCase(Constants.UploadType.LIS.toString())) {
//                List<RegPatientinfo> list =  saveDate.updateState();
//                List<Integer> ids = new ArrayList<>();
//                String idStr = JSON.toJSONString(ids);
//                String info = cloudFeignClient.pullReg(idStr);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
