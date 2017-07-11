package com.jfsoft.task.service;

/**
 * 定时任务业务接口
 * wanggang
 * 2017-7-11 13:36:51
 */
public interface ITaskService {

    /**
     * 调用存储过程，返回用户信息
     * @author wanggang
     * 2017年4月10日 下午2:30:42
     * @param areacode 区域编码
     * @param rowlimit 查询返回的行数
     * @return
     * @throws Exception
     */
    public String getPerCheckInfoProc(String areacode, String localFileDir, String rowlimit) throws Exception;

    /**
     * 调用存储过程，返回用户信息
     * @author wanggang
     * 2017年4月10日 下午2:30:42
     * @param areacode 区域编码
     * @param rowlimit 查询返回的行数
     * @return
     * @throws Exception
     */
    public String getLisPatientInfoProc(String areacode, String rowlimit) throws Exception;

}
