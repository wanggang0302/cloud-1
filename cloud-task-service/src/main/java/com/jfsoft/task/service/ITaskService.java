package com.jfsoft.task.service;

import java.awt.*;

/**
 * 定时任务业务接口
 * wanggang
 * 2017-7-11 13:36:51
 */
public interface ITaskService {

    /**
     * 数据处理
     * wanggang
     * 2017-07-24 13:48:37
     * @param type 要处理的数据类型：Lis、PEIS、通用类数据处理
     */
    public void processData(String type) throws Exception;

    ///**
    // * 调用存储过程，返回用户信息
    // * @author wanggang
    // * 2017年4月10日 下午2:30:42
    // * @param areacode 区域编码
    // * @param rowlimit 查询返回的行数
    // * @return
    // * @throws Exception
    // */
    //public String getPerCheckInfoProc(String areacode, String rowlimit) throws Exception;
    //
    ///**
    // * 调用存储过程，返回用户信息
    // * @author wanggang
    // * 2017年4月10日 下午2:30:42
    // * @param areacode 区域编码
    // * @param rowlimit 查询返回的行数
    // * @return
    // * @throws Exception
    // */
    //public String getLisPatientInfoProc(String areacode, String rowlimit) throws Exception;
}
