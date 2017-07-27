package com.jfsoft.cloud.service.impl;

import com.jfsoft.cloud.entity.TcLisPatientinfo;
import com.jfsoft.cloud.mapper.TcLisPatientinfoMapper;
import com.jfsoft.cloud.service.ILisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ChenXc
 * @version V1.0
 * @Date 2017/6/29  10:42
 * @Description TODO(一句话描述类作用)
 */
@Service
public class LisServiceImpl implements ILisService{

    @Autowired
    private TcLisPatientinfoMapper tcLisPatientinfoMapper;


    @Override
    public Integer insertLisPercheckinfo(TcLisPatientinfo tcLisPatientinfo) {
        return tcLisPatientinfoMapper.insertSelective(tcLisPatientinfo);
    }
}
