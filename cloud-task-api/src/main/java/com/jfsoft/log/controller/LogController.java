package com.jfsoft.log.controller;

import com.jfsoft.log.service.ITcLogService;
import com.jfsoft.task.entity.TcLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * 日志管理
 * wanggang
 * 2017-7-10 16:23:46
 */
@Controller
public class LogController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ITcLogService tcLogService;

    /**
     * 查询日志列表
     * wanggang
     * 2017-7-10 16:23:36
     * @param map
     * @return
     */
    @RequestMapping("/logs")
    public String logs(Map<String,Object> map, String upMechName, String upType, String upStatus,
                       String upDateBegin, String upDateEnd) {

        try {
            List<TcLog> tcLogList = tcLogService.findList(upMechName, upType, upStatus, upDateBegin, upDateEnd);

            map.put("tcLogList", tcLogList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "logList";
    }



}
