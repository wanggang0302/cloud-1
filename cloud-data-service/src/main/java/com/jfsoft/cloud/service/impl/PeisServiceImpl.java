package com.jfsoft.cloud.service.impl;

import com.jfsoft.cloud.service.IPeisService;
import com.jfsoft.cloud.entity.TcPerCheckinfo;
import com.jfsoft.cloud.mapper.TcPerCheckinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PEIS（体检）接口实现类
 * wanggang
 * 2017-07-28 10:31:57
 */
@Service
public class PeisServiceImpl implements IPeisService {

    @Autowired
    private TcPerCheckinfoMapper tcPerCheckinfoMapper;

    public Integer insertPeisPercheckinfo(TcPerCheckinfo tcPerCheckinfo) {
        return tcPerCheckinfoMapper.insertSelective(tcPerCheckinfo);
    }

}
