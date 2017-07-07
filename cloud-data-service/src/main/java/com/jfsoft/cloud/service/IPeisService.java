package com.jfsoft.cloud.service;

import com.jfsoft.cloud.entity.TcPerCheckinfo;

/**
 * Created by web on 2017/6/28.
 */
public interface IPeisService {

    /**
     * 插入体检人员信息
     * @return
     */
    Integer insertPeisPercheckinfo(TcPerCheckinfo tcPerCheckinfo);

}
