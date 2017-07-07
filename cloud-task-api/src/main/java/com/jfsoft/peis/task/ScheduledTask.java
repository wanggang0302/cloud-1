package com.jfsoft.peis.task;

import com.jfsoft.task.entity.TcLisPatientinfo;
import com.jfsoft.task.service.ITaskService;
import com.jfsoft.task.service.ICloudFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by web on 2017/6/29.
 */
@Component
public class ScheduledTask {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ITaskService taskService;

    @Autowired
    private ICloudFeignClient cloudFeignClient;

    @Autowired
    private TcLisPatientinfo tcLisPatientinfo;

    @Value("${task.procedure.rowlimit}")
    private String rowlimit;

    @Value("${up.type}")
    private String type;

    @Scheduled(cron = "${task.time}")
    public void execute() {
        System.out.println("现在时间是："+System.currentTimeMillis());
        try {
            if(type.equals("peis")){
                String state = taskService.getPerCheckInfoProc("001", rowlimit);
                System.out.println("---------数据上传状态为--------" + state);
            }else if(type.equals("lis")){
                System.out.println("peis服务启动");
                //从LIS表中获取filepath
                String filepath = "E:/images/a.jpg";
                //获取本地图片流，上传
                FileInputStream fs =new FileInputStream(filepath);
                //获取文件名
                File file = new File(filepath);
                String picName = file.getName();
                MockMultipartFile pic = new MockMultipartFile("file",picName,"",fs);
                Map<String, Object> map = new HashMap<String, Object>();
                map = cloudFeignClient.uploadPic(pic);
                String filePath = (String) map.get("filePath");
                //重新组装检验信息，更新filePath字段
                tcLisPatientinfo.setFilepath(filepath);
                //调用lisSave接口，发送重新组装的消息
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
