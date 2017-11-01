package com.jfsoft.log.controller;

import com.alibaba.fastjson.JSON;
import com.jfsoft.log.service.ITcLogService;
import com.jfsoft.task.entity.TcLog;
import com.jfsoft.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
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
     * @param
     * @return
     */
    @RequestMapping("/logs")
    @ResponseBody
    public String logs(Integer pageIndex, Integer pageSize, String upMechName, String upType, String upStatus,
                       String upDateBegin, String upDateEnd) {

        Map<String, Object> map = new HashMap<>();

        try {
            List<TcLog> tcLogList = tcLogService.findList(pageIndex, pageSize, upMechName, upType, upStatus, upDateBegin, upDateEnd);
            map.put("status", "success");
            map.put("logList", tcLogList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return JSON.toJSONString(map);
    }

    /**
     * 跳转到日志页面
     * @return
     */
    @RequestMapping("/toLog")
    public String toLog() {
        return "logList";
    }

}
