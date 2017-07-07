/**
 * TcPerCheckinfo.java
 * Copyright© 2017 北京金风易通科技有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2017-06-28 Created
 */
package com.jfsoft.task.entity;

import java.util.Date;

/**
 * 体检人员信息表
 * 
 * @author wanggang
 * @version 1.0 2017-06-28
 */
public class TcPerCheckinfo {

    /**
     * 编号
     */
    private Integer id;

    /**
     * 医院编码
     */
    private String hospitalCode;

    /**
     * 体检号
     */
    private String testno;

    /**
     * 档案号
     */
    private String recodeno;

    /**
     * 姓名
     */
    private String name;

    /**
     * 拼音码
     */
    private String pycode;

    /**
     * 性别(1男2女)
     */
    private Integer sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 年龄单位
     */
    private String ageunit;

    /**
     * 出生日期
     */
    private Date birthday;

    /**
     * 预约时间(排期时间)
     */
    private Date ordertime;

    /**
     * 预约人
     */
    private String orderuser;

    /**
     * 签到时间
     */
    private Date signtime;

    /**
     * 签到确认人
     */
    private String signuser;

    /**
     * 体检次数(根据档案号计算)
     */
    private Integer testcount;

    /**
     * 会员卡号
     */
    private Integer cardnum;

    /**
     * 医院就诊卡号
     */
    private String medicalcardnum;

    /**
     * 单位组别名称
     */
    private String unitname;

    /**
     * 职业
     */
    private String profession;

    /**
     * 工种
     */
    private String worktype;

    /**
     * 自编号(单位体检自定义号码)
     */
    private String selfnum;

    /**
     * 工号
     */
    private String jobnum;

    /**
     * 体检类别(岗前体检，军人体检，幼儿园体检)
     */
    private String testtype;

    /**
     * 体检卡号
     */
    private String peisnum;

    /**
     * 付费方式(公费，医保，自费)
     */
    private String paytype;

    /**
     * 套餐编号
     */
    private Integer boxcode;

    /**
     * 套餐名称(套餐变更就为自定义套餐)
     */
    private String boxname;

    /**
     * 体检批次
     */
    private String batchno;

    /**
     * 身份证号
     */
    private String ssid;

    /**
     * 民族
     */
    private String nation;

    /**
     * 通讯地址
     */
    private String addr;

    /**
     * 邮箱
     */
    private String postno;

    /**
     * 血型
     */
    private String abo;

    /**
     * 学历
     */
    private String degree;

    /**
     * 社保号
     */
    private String ssno;

    /**
     * 医保号
     */
    private String healthcardnum;

    /**
     * 电话
     */
    private String tel;

    /**
     * 体检状态(10,已登记;30,分检中;40,待总检;50,已总检;60,已打印;70,已领取)
     */
    private Integer statuscode;

    /**
     * 提示信息(主要给分检科室看(比如体检人员是领导))
     */
    private String notice;

    /**
     * 备注
     */
    private String memo;

    /**
     * 区域编号
     */
    private String areacode;

    /**
     * 婚姻状况
     */
    private String marriage;

    /**
     * 全部信息
     */
    private String perinfo;
    /**
     */
    private String reserve1;

    /**
     */
    private String reserve2;

    /**
     */
    private String reserve3;

    /**
     */
    private String reserve4;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHospitalCode() {
        return hospitalCode;
    }

    public void setHospitalCode(String hospitalCode) {
        this.hospitalCode = hospitalCode == null ? null : hospitalCode.trim();
    }

    public String getTestno() {
        return testno;
    }

    public void setTestno(String testno) {
        this.testno = testno == null ? null : testno.trim();
    }

    public String getRecodeno() {
        return recodeno;
    }

    public void setRecodeno(String recodeno) {
        this.recodeno = recodeno == null ? null : recodeno.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPycode() {
        return pycode;
    }

    public void setPycode(String pycode) {
        this.pycode = pycode == null ? null : pycode.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAgeunit() {
        return ageunit;
    }

    public void setAgeunit(String ageunit) {
        this.ageunit = ageunit == null ? null : ageunit.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public String getOrderuser() {
        return orderuser;
    }

    public void setOrderuser(String orderuser) {
        this.orderuser = orderuser == null ? null : orderuser.trim();
    }

    public Date getSigntime() {
        return signtime;
    }

    public void setSigntime(Date signtime) {
        this.signtime = signtime;
    }

    public String getSignuser() {
        return signuser;
    }

    public void setSignuser(String signuser) {
        this.signuser = signuser == null ? null : signuser.trim();
    }

    public Integer getTestcount() {
        return testcount;
    }

    public void setTestcount(Integer testcount) {
        this.testcount = testcount;
    }

    public Integer getCardnum() {
        return cardnum;
    }

    public void setCardnum(Integer cardnum) {
        this.cardnum = cardnum;
    }

    public String getMedicalcardnum() {
        return medicalcardnum;
    }

    public void setMedicalcardnum(String medicalcardnum) {
        this.medicalcardnum = medicalcardnum == null ? null : medicalcardnum.trim();
    }

    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname == null ? null : unitname.trim();
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession == null ? null : profession.trim();
    }

    public String getWorktype() {
        return worktype;
    }

    public void setWorktype(String worktype) {
        this.worktype = worktype == null ? null : worktype.trim();
    }

    public String getSelfnum() {
        return selfnum;
    }

    public void setSelfnum(String selfnum) {
        this.selfnum = selfnum == null ? null : selfnum.trim();
    }

    public String getJobnum() {
        return jobnum;
    }

    public void setJobnum(String jobnum) {
        this.jobnum = jobnum == null ? null : jobnum.trim();
    }

    public String getTesttype() {
        return testtype;
    }

    public void setTesttype(String testtype) {
        this.testtype = testtype == null ? null : testtype.trim();
    }

    public String getPeisnum() {
        return peisnum;
    }

    public void setPeisnum(String peisnum) {
        this.peisnum = peisnum == null ? null : peisnum.trim();
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype == null ? null : paytype.trim();
    }

    public Integer getBoxcode() {
        return boxcode;
    }

    public void setBoxcode(Integer boxcode) {
        this.boxcode = boxcode;
    }

    public String getBoxname() {
        return boxname;
    }

    public void setBoxname(String boxname) {
        this.boxname = boxname == null ? null : boxname.trim();
    }

    public String getBatchno() {
        return batchno;
    }

    public void setBatchno(String batchno) {
        this.batchno = batchno == null ? null : batchno.trim();
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid == null ? null : ssid.trim();
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public String getPostno() {
        return postno;
    }

    public void setPostno(String postno) {
        this.postno = postno == null ? null : postno.trim();
    }

    public String getAbo() {
        return abo;
    }

    public void setAbo(String abo) {
        this.abo = abo == null ? null : abo.trim();
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree == null ? null : degree.trim();
    }

    public String getSsno() {
        return ssno;
    }

    public void setSsno(String ssno) {
        this.ssno = ssno == null ? null : ssno.trim();
    }

    public String getHealthcardnum() {
        return healthcardnum;
    }

    public void setHealthcardnum(String healthcardnum) {
        this.healthcardnum = healthcardnum == null ? null : healthcardnum.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public Integer getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(Integer statuscode) {
        this.statuscode = statuscode;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice == null ? null : notice.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode == null ? null : areacode.trim();
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage == null ? null : marriage.trim();
    }

    public String getReserve1() {
        return reserve1;
    }

    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1 == null ? null : reserve1.trim();
    }

    public String getReserve2() {
        return reserve2;
    }

    public void setReserve2(String reserve2) {
        this.reserve2 = reserve2 == null ? null : reserve2.trim();
    }

    public String getReserve3() {
        return reserve3;
    }

    public void setReserve3(String reserve3) {
        this.reserve3 = reserve3 == null ? null : reserve3.trim();
    }

    public String getReserve4() {
        return reserve4;
    }

    public void setReserve4(String reserve4) {
        this.reserve4 = reserve4 == null ? null : reserve4.trim();
    }

    public String getPerinfo() {
        return perinfo;
    }

    public void setPerinfo(String perinfo) {
        this.perinfo = perinfo;
    }

}
