/**
 * TcLogMapper.java
 * Copyright© 2017 北京金风易通科技有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2017-06-26 Created
 */
package com.jfsoft.cloud.mapper;

import com.jfsoft.cloud.entity.TcLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TcLogMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(TcLog record);

    int insertSelective(TcLog record);

    TcLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TcLog record);

    int updateByPrimaryKey(TcLog record);

}