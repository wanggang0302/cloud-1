/**
 * TcLisPatientinfoMapper.java
 * Copyright© 2017 北京金风易通科技有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2017-06-29 Created
 */
package com.jfsoft.cloud.mapper;


import com.jfsoft.cloud.entity.TcLisPatientinfo;

public interface TcLisPatientinfoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(TcLisPatientinfo record);

    int insertSelective(TcLisPatientinfo record);

    TcLisPatientinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TcLisPatientinfo record);

    int updateByPrimaryKey(TcLisPatientinfo record);
    
}
