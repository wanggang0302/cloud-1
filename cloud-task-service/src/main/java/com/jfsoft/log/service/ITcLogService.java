package com.jfsoft.log.service;

import com.jfsoft.task.entity.TcLog;

import java.util.List;

/**
 * 日志保存业务接口
 * wanggang
 * 2017-7-10 16:00:53
 */
public interface ITcLogService {

    /**
     * 保存日志
     * @author wanggang
     * 2017-7-10 16:00:34
     * @param tcLog
     * @throws Exception
     */
    public void save(TcLog tcLog) throws Exception;

    /**
     * 查询日志列表
     * @param upMechName 医院名称（模糊匹配）
     * @param upType 上传类型（LIS、PEIS、通用类消息）
     * @param upStatus 上传状态
     * @param upDateBegin 上传时间（查询条件的开始时间）
     * @param upDateEnd 上传时间（查询条件的结束时间）
     * @return
     * @throws Exception
     */
    public List<TcLog> findList(String upMechName, String upType, String upStatus,
                                String upDateBegin, String upDateEnd) throws Exception;

}
