/**
 * TcLog.java
 * Copyright© 2017 北京金风易通科技有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2017-06-26 Created
 */
package com.jfsoft.cloud.entity;

import java.util.Date;

/**
 * null
 * 
 * @author wanggang
 * @version 1.0 2017-06-26
 */
public class TcLog {

    /**
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
    private Boolean upStatus;

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
        this.upMechCode = upMechCode == null ? null : upMechCode.trim();
    }

    public String getUpMechName() {
        return upMechName;
    }

    public void setUpMechName(String upMechName) {
        this.upMechName = upMechName == null ? null : upMechName.trim();
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
        this.upType = upType == null ? null : upType.trim();
    }

    public Boolean getUpStatus() {
        return upStatus;
    }

    public void setUpStatus(Boolean upStatus) {
        this.upStatus = upStatus;
    }

}
