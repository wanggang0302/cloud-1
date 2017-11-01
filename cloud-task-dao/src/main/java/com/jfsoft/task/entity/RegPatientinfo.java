package com.jfsoft.task.entity;

import java.math.BigInteger;
import java.util.Date;

/**
 * @author ChenXc
 * @version V1.0
 * @Date 2017/9/25  10:01
 * @Description TODO(一句话描述类作用)
 */
public class RegPatientinfo {
    /**
     * 人员ID 主键，自增
     */
    private Integer patinfoId;

    /**
     * 机构编码
     */
    private String orgCode;

    /**
     * 医院编码
     */
    private String areaCode;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 年龄单位
     */
    private String ageUnit;

    /**
     * 开单医生
     */
    private String billDoc;

    /**
     * 开单科室
     */
    private String billDept;

    /**
     * 收费金额
     */
    private Float feeMoney;

    /**
     * 申请时间
     */
    private Date reqTime;

    /**
     * 临床诊断
     */
    private String lczd;


    /**
     * 状态码
     */
    private Integer statusCode;

    private Integer groupCode;

    /**
     */
    private String groupName;

    /**
     * 条码
     */
    private BigInteger barCode;

    /**
     * 样本备注
     */
    private String sampleMemo;


    private Integer itemCode;

    /**
     */
    private String itemName;

    /**
     */
    private Float itemFee;

    private Integer deltag;

    public Integer getDeltag() {
        return deltag;
    }

    public void setDeltag(Integer deltag) {
        this.deltag = deltag;
    }

    public Integer getItemCode() {
        return itemCode;
    }

    public void setItemCode(Integer itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Float getItemFee() {
        return itemFee;
    }

    public void setItemFee(Float itemFee) {
        this.itemFee = itemFee;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public BigInteger getBarCode() {
        return barCode;
    }

    public void setBarCode(BigInteger barCode) {
        this.barCode = barCode;
    }

    public String getSampleMemo() {
        return sampleMemo;
    }

    public void setSampleMemo(String sampleMemo) {
        this.sampleMemo = sampleMemo;
    }

    public Integer getPatinfoId() {
        return patinfoId;
    }

    public void setPatinfoId(Integer patinfoId) {
        this.patinfoId = patinfoId;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAgeUnit() {
        return ageUnit;
    }

    public void setAgeUnit(String ageUnit) {
        this.ageUnit = ageUnit;
    }

    public String getBillDoc() {
        return billDoc;
    }

    public void setBillDoc(String billDoc) {
        this.billDoc = billDoc;
    }

    public String getBillDept() {
        return billDept;
    }

    public void setBillDept(String billDept) {
        this.billDept = billDept;
    }

    public Float getFeeMoney() {
        return feeMoney;
    }

    public void setFeeMoney(Float feeMoney) {
        this.feeMoney = feeMoney;
    }

    public Date getReqTime() {
        return reqTime;
    }

    public void setReqTime(Date reqTime) {
        this.reqTime = reqTime;
    }

    public String getLczd() {
        return lczd;
    }

    public void setLczd(String lczd) {
        this.lczd = lczd;
    }

    public Integer getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(Integer groupCode) {
        this.groupCode = groupCode;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
}
