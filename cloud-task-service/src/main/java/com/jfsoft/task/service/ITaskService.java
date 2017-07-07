package com.jfsoft.task.service;

/**
 * Created by web on 2017/6/29.
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
    public String getPerCheckInfoProc(String areacode, String rowlimit) throws Exception;

}
