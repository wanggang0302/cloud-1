package com.jfsoft.task.service.process;

/**
 * 数据处理接口
 * wanggang
 * 2017-07-24 10:14
 */
public interface ITaskDataProcess {

    /**
     * 上传数据到云平台
     * @param hospitalId 医院编码
     * @param rowlimit 每次上传查询的条数
     * @return
     * @throws Exception
     */
    public void uploadData(String hospitalId, String rowlimit) throws Exception;

    /**
     * 保存已登记人员信息
     * @throws Exception
     */
//    public void saveRegDate() throws Exception;

}
