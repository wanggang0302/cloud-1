package com.jfsoft.cloud.service.impl;


import com.jfsoft.cloud.entity.TcLog;
import com.jfsoft.cloud.mapper.TcLogMapper;
import com.jfsoft.cloud.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by web on 2017/6/26.
 */
@Service("tcLogService")
public class LogServiceImpl implements ILogService {

    @Autowired
    private TcLogMapper tcLogMapper;

    /**
     * 日志插入
     * @param tcLog
     * @return
     */
    public Integer insertSysLog(TcLog tcLog) {
        return tcLogMapper.insertSelective(tcLog);
    }

}
