/**
 * TcLogMapper.java
 * Copyright© 2017 北京金风易通科技有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2017-07-10 Created
 */
package com.jfsoft.task.mapper;

import com.jfsoft.task.entity.TcLog;

import java.util.List;
import java.util.Map;

/**
 * 日志dao
 * wanggang
 * 2017-7-10 16:45:18
 */
public interface TcLogMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(TcLog record);

    int insertSelective(TcLog record);

    TcLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TcLog record);

    int updateByPrimaryKey(TcLog record);

    /**
     * 查询日志列表
     * wanggang
     * 2017-7-10 16:45:28
     */
    List<TcLog> selectLogList(Map<String, Object> params);

    /**
     * 查询上传失败的日志记录
     * wanggang
     * 2017-07-28 13:28:27
     */
    List<Map<String, Object>> selectUploadFailureLog(Map<String, Object> params);

}