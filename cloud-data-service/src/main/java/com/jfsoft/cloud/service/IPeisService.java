package com.jfsoft.cloud.service;

import com.jfsoft.cloud.entity.TcPerCheckinfo;

/**
 * PEIS（体检）接口
 */
public interface IPeisService {

    /**
     * 插入体检人员信息
     * @return
     */
    Integer insertPeisPercheckinfo(TcPerCheckinfo tcPerCheckinfo);

}
