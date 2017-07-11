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
     * 主键
     */
    private Integer id;

    /**
     * 上传机构代码
     */
    private String upMechCode;

    /**
     * 上传机构名称
     */
    private String upMechName;

    /**
     * 上传时间
     */
    private Date upDate;

    /**
     * 上传类型（LIS、PEIS、通用类消息）
     */
    private String upType;

    /**
     * 上传状态
     */
    private Short upStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUpMechCode() {
        return upMechCode;
    }

    public void setUpMechCode(String upMechCode) {
        this.upMechCode = upMechCode;
    }

    public String getUpMechName() {
        return upMechName;
    }

    public void setUpMechName(String upMechName) {
        this.upMechName = upMechName;
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

    public Short getUpStatus() {
        return upStatus;
    }

    public void setUpStatus(Short upStatus) {
        this.upStatus = upStatus;
    }

}
