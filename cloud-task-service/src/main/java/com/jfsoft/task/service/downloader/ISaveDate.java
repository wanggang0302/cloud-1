package com.jfsoft.task.service.downloader;

/**
 * @author ChenXc
 * @version V1.0
 * @Date 2017/10/11  9:39
 * @Description TODO(定时保存数据)
 */
public interface ISaveDate {

    /**
     * 保存已注册人员
     * @param regInfo
     * @return
     * @throws Exception
     */
    public int saveRegInfo(String regInfo) throws Exception;
}
