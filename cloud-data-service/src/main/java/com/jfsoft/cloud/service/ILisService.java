package com.jfsoft.cloud.service;


import com.jfsoft.cloud.entity.TcLisPatientinfo;

/**
 * @author ChenXc
 * @version V1.0
 * @Date 2017/6/29  10:42
 * @Description TODO(一句话描述类作用)
 */
public interface ILisService {
    /**
     * 插入检验人员信息
     * @return
     */
    Integer insertLisPercheckinfo(TcLisPatientinfo tcLisPatientinfo);
}
