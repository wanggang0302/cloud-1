package com.jfsoft.cloud.service;


import com.jfsoft.cloud.entity.TcLog;

/**
 * Created by web on 2017/6/26.
 * TODO(保存日志接口)
 */
public interface ILogService {
    /**
     * 插入日志
     * @param tcLog
     * @return
     */
    Integer insertSysLog(TcLog tcLog);

}
