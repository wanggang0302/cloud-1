package com.jfsoft.task.entity;

import java.util.Date;

/**
 * 日志
 *
 * @author wanggang
 * @version 1.0 2017-07-10
 */
public class TcLog {

    /**
     * 自增主键
     */
    private String id;

    /**
     * 上传的数据的ID
     */
    private String upDataId;

    /**
     * 上传时间
     */
    private Date upDate;

    /**
     * 上传类型(10:LIS,20:PEIS,30:通用类消息)
     */
    private String upType;

    /**
     * 上传状态(0:成功,1:失败)
     */
    private String upStatus;

    /**
     * 上传状态详细描述
     */
    private String upStatusInfo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUpDataId() {
        return upDataId;
    }

    public void setUpDataId(String upDataId) {
        this.upDataId = upDataId;
    }

    public Date getUpDate() {
        return upDate;
    }

    public void setUpDate(Date upDate) {
        this.upDate = upDate;
    }

    public String getUpType() {
        return upType;
    }

    public void setUpType(String upType) {
        this.upType = upType;
    }

    public String getUpStatus() {
        return upStatus;
    }

    public void setUpStatus(String upStatus) {
        this.upStatus = upStatus;
    }

    public String getUpStatusInfo() {
        return upStatusInfo;
    }

    public void setUpStatusInfo(String upStatusInfo) {
        this.upStatusInfo = upStatusInfo;
    }

}
