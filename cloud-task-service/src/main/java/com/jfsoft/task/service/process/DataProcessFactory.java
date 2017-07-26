package com.jfsoft.task.service.process;

import com.jfsoft.task.service.ITaskService;
import com.jfsoft.task.service.process.impl.LisDataProcessImpl;
import com.jfsoft.task.service.process.impl.PeisDataProcessImpl;
import com.jfsoft.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 数据处理工厂类
 * wanggang
 * 2017-07-24 10:17
 */
@Component
public class DataProcessFactory {

    //日志
    private final Logger logger = LoggerFactory.getLogger(getClass());

    //体检数据上传
    @Autowired
    private PeisDataProcessImpl peisDataProcess;

    //Lis数据上传
    @Autowired
    private LisDataProcessImpl lisDataProcess;

    public ITaskDataProcess create(String type) {

        if(type.equalsIgnoreCase(Constants.UploadType.PEIS.toString())) {
            return peisDataProcess;
        } else if(type.equalsIgnoreCase(Constants.UploadType.LIS.toString())) {
            return lisDataProcess;
        } else {
            logger.error("The type of message which named " + type + " that is not recognized");
        }

        return null;
    }

}
