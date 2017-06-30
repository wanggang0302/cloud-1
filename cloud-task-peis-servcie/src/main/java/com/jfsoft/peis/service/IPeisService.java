package com.jfsoft.peis.service;

/**
 * Created by web on 2017/6/29.
 */
public interface IPeisService {

    /**
     * 调用存储过程，返回用户信息
     * @author wanggang
     * 2017年4月10日 下午2:30:42
     * @param testno 体检号
     * @param areacode 区域编号
     * @return
     * @throws Exception
     */
    public String getPerCheckInfoProc(String testno, String areacode) throws Exception;

}
