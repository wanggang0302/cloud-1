package com.jfsoft.cloud.service.impl;

import com.jfsoft.cloud.service.IPeisService;
import com.jfsoft.cloud.entity.TcPerCheckinfo;
import com.jfsoft.cloud.mapper.TcPerCheckinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by web on 2017/6/28.
 */
@Service
public class PeisServiceImpl implements IPeisService {

    @Autowired
    private TcPerCheckinfoMapper tcPerCheckinfoMapper;


    @Override
    public Integer insertPeisPercheckinfo(TcPerCheckinfo tcPerCheckinfo) {
        return tcPerCheckinfoMapper.insertSelective(tcPerCheckinfo);
    }

}
