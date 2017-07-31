/**
 * TcPerCheckinfoMapper.java
 * Copyright© 2017 北京金风易通科技有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2017-06-28 Created
 */
package com.jfsoft.cloud.mapper;

import com.jfsoft.cloud.entity.TcPerCheckinfo;

public interface TcPerCheckinfoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(TcPerCheckinfo record);

    int insertSelective(TcPerCheckinfo record);

    TcPerCheckinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TcPerCheckinfo record);

    int updateByPrimaryKey(TcPerCheckinfo record);

}
