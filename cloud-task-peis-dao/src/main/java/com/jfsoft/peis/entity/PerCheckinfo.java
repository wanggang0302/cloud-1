package com.jfsoft.peis.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 体检人员检查信息表
 * @author wanggang
 * 2017年3月20日 下午1:31:57
 */
public class PerCheckinfo implements java.io.Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

    private String testno;
    /**
     * 体检号别名PID
     */
    private String pID;
    private String recodeno;
    private String name;

    private String pycode;
   
    private BigDecimal sex;
    private BigDecimal age;

    private BigDecimal ageunitcode;
    
    private String ageunitname;
    
    public String getAgeunitname() {
		return ageunitname;
	}

	public void setAgeunitname(String ageunitname) {
		this.ageunitname = ageunitname;
	}
	/**
	 * 序号
	 */
	private BigDecimal rownum;
	/**
	 * 自编号
	 */
	private String cusnum;
	/**
	 * 集团名称
	 */
	private String comname;
	
	/**
	 * 
	 */
	private Boolean impo;
	
	public BigDecimal getRownum() {
		return rownum;
	}

	public void setRownum(BigDecimal rownum) {
		this.rownum = rownum;
	}

	public String getCusnum() {
		return cusnum;
	}

	public void setCusnum(String cusnum) {
		this.cusnum = cusnum;
	}

	public String getComname() {
		return comname;
	}

	public void setComname(String comname) {
		this.comname = comname;
	}

	public Boolean getImpo() {
		return impo;
	}

	public void setImpo(Boolean impo) {
		this.impo = impo;
	}
	/**
     * 年龄单位
     */
    private String ageUnit;
    /**
     * 床号
     */
    private String bedNum;
    /**
     * 科室号
     */
    private String department;
    
    /**
     * 医生编号
     */
    private String doctor;
    /**
     * 性别
     */
    private String sexStr;
    
	/**
     * 组合项目名称
     */
    private String sFName;
    
    /**
     * 组合项目code
     */
    private String sFCode;
    
    /**
     * 收费金额
     */
    private String sFMoney;
    /**
     * 收费次数
     */
    private String sFCount;
    
    /**
     * 收费时间
     */
    private String sFTime;
    
    /**
     * 
     */
    private String fPH;
    
    /**
     * 临床诊断
     */
    private String lczd;
    
    /**
     * 病人类型
     */
    private String patType;
    
    /**
     * 
     */
    private String hisID;
    
    /**
     * 条码号
     */
    private String barCode;
    
    /**
     * lis标识
     */
    private String lisbz;
    
    /**
     * 冠新接口：健康体检表编号
     */
    private String healthExamNo;
    /**
     * 冠新接口：体检日期
     */
    private Date healthExamDate;
    /**
	 * 责任医师姓名
	 */
	private String respDoctorName;
	/**
	 * 责任医生ID
	 */
	private String respDoctorId;
	
	private String persongroup;
	private Date birthday;
    
    /**
     * 出生日期字符串
     */
    private String birthdayStr;

    private Date ordertime;

    private BigDecimal orderusercode;

    private Date signtime;
    /**
     * 签到时间字符串
     */
    private String signtimeStr;
    
    private BigDecimal signusercode;

    private BigDecimal testcount;
    private String cardnum;
    private String medicalcardnum;

    private BigDecimal unitcode;
    private String profession;
    private String worktype;

    private String selfnum;
    private String jobnum;
    private String testtype;
    private String peisnum;

    private String paytype;

    private BigDecimal boxcode;
    private String boxname;
    
    /**
     * 1.满月
		2.3月龄
		3.6月龄
		4.8月龄
		5.12月龄
		6.18月龄
		7.24月龄
		8.30月龄
		9.3岁
		10.4岁
		11.5岁
		12.6岁
		13.中小学生健康体检
		14.高等学校健康体检
		15.15岁及以上城乡居民
		16.企业退休职工
		17.公职人员
     * add by wanggang 2017-5-23 18:03:27
     */
    private String examtype;
    private String batchno;
    private String ssid;
    private String nation;
    private String addr;
    private String postno;
    private String abo;
    private String degree;
    private String ssno;

    private String healthcardnum;
    private String tel;

    private Date recordtime;
    private String recordtimeStr;

    private BigDecimal recordusercode;

    private Date modifytime;    

    private BigDecimal modifyusercode;

    private String photoid;

    private String signid;

    private BigDecimal statuscode;
	private String notice;
    private String memo;
    private String marriage;
    /**
     * 个人照片
     */
    private String photofile;

	public String getPhotofile() {
		return photofile;
	}

	public void setPhotofile(String photofile) {
		this.photofile = photofile;
	}
	
	private String areacode;
	
	/**
	 * add by wanggang 2017-5-31 15:57:37
	 * for 冠新提供体检者信息json
	 * 区域在冠新平台的编号
	 */
	private String areaHisCode;
	
	/**
	 * 区域名称
	 */
	private String areaname;
	
	/**
	 * 现住址
	 */
	private String presentaddr;
	
	/**
	 * 社保类型
	 */
	private String ssstyle;
	
	/**
	 * 所在社区
	 */
	private String community;

	/**
     * 体检状态标志
     */
    private String flag;
    
    /**
     * 冠新体检id
     */
    private String outHealthexamid;
    
    public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	private Short checkbox;
    /**
     * 主检医生
     */
    private String auditdoctor;
    /**
     * 审核医生
     */
    private String totaldoctor;
    /**
     * 预约时间字符串
     */
    private String ordertimeStr;
    
    /**
     * 单位名称
     */
    private String companyName;
    /**
     * 单位编号
     */
    private int companyCode;
    public String getAuditdoctor() {
		return auditdoctor;
	}

	public void setAuditdoctor(String auditdoctor) {
		this.auditdoctor = auditdoctor;
	}

	public String getTotaldoctor() {
		return totaldoctor;
	}

	public void setTotaldoctor(String totaldoctor) {
		this.totaldoctor = totaldoctor;
	}
	/**
     * 部门编号
     */
	
    private int deptCode;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 组名称
     */
    private String groupName;
    
    /**
     * 首检时间
     */
    private Date firstTestTime;
    
    /**
     * 分检完成时间(待总检时间)
     */
    private Date finishTestTime;
    
    /**
     * 总检时间
     */
    private Date totalTestTime;
    
    /**
     * 报告打印时间
     */
    private Date reportPrintTime;
    
    /**
	 * 个人档案ID 数据库字段
	 * wanggang
	 * 2017年4月23日17:37:34
	 */
    private String outRecodeno;
    /**
     * 个人档案ID 页面属性
     * wanggang
     * 2017年4月23日17:37:50
     */
    /**
     * 统计总检时间
     */
    private Date totaltime;
    

    /**
     * 是否团检（0个检、1团检）
     */
   
    private Short personType;
    
    private String teamorsingle;
    
    public String getTeamorsingle() {
		return teamorsingle;
	}

	public void setTeamorsingle(String teamorsingle) {
		this.teamorsingle = teamorsingle;
	}
	/**
     * 户籍类型（0非户籍、1户籍）
     */
  
    private Short householdtype;
    private String housestyle;
    
    public String getHousestyle() {
		return housestyle;
	}

	public void setHousestyle(String housestyle) {
		this.housestyle = housestyle;
	}
	/**
     * 联系人姓名
     */
    private String contactname;

    /**
     * 联系人电话
     */
    private String contacttel;
    
    /**
     * 现有疾病（字符串，疾病名称，用","隔开）
     */
    private String illness;
    
	public String getIllness() {
		return illness;
	}

	public void setIllness(String illness) {
		this.illness = illness;
	}

	public Short getPersonType() {
		return personType;
	}

	public void setPersonType(Short personType) {
		this.personType = personType;
	}

	public Short getHouseholdtype() {
		return householdtype;
	}

	public void setHouseholdtype(Short householdtype) {
		this.householdtype = householdtype;
	}

	public String getContactname() {
		return contactname;
	}

	public void setContactname(String contactname) {
		this.contactname = contactname;
	}

	public String getContacttel() {
		return contacttel;
	}

	public void setContacttel(String contacttel) {
		this.contacttel = contacttel;
	}

	public String getPersongroup() {
		return persongroup;
	}

	public void setPersongroup(String persongroup) {
		this.persongroup = persongroup;
	}

	public Date getTotaltime() {
		return totaltime;
	}

	public void setTotaltime(Date totaltime) {
		this.totaltime = totaltime;
	}
	private String personInfoId;
    
    /**
     * 体检状态 中文字符串
     */
    private String status;
    
    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPersonInfoId() {
		return personInfoId;
	}

	public void setPersonInfoId(String personInfoId) {
		this.personInfoId = personInfoId;
	}

	public String getOutHealthexamid() {
		return outHealthexamid;
	}

	public void setOutHealthexamid(String outHealthexamid) {
		this.outHealthexamid = outHealthexamid;
	}

	public String getOutRecodeno() {
		return outRecodeno;
	}

	public void setOutRecodeno(String outRecodeno) {
		this.outRecodeno = outRecodeno;
	}

	public String getOrdertimeStr() {
		return ordertimeStr;
	}

	public void setOrdertimeStr(String ordertimeStr) {
		this.ordertimeStr = ordertimeStr;
	}

	public String getRecordtimeStr() {
		return recordtimeStr;
	}

	public void setRecordtimeStr(String recordtimeStr) {
		this.recordtimeStr = recordtimeStr;
	}

	public int getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(int companyCode) {
		this.companyCode = companyCode;
	}

	public int getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(int deptCode) {
		this.deptCode = deptCode;
	}
	/**
     * 领取报告时间
     */
    private Date getReportTime;

    public String getBirthdayStr() {
		return birthdayStr;
	}

	public void setBirthdayStr(String birthdayStr) {
		this.birthdayStr = birthdayStr;
	}

	public String getSigntimeStr() {
		return signtimeStr;
	}

	public void setSigntimeStr(String signtimeStr) {
		this.signtimeStr = signtimeStr;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTestno() {
        return testno;
    }

    public void setTestno(String testno) {
        this.testno = testno;
    }

    public String getRecodeno() {
		return recodeno;
	}

	public void setRecodeno(String recodeno) {
		this.recodeno = recodeno;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPycode() {
        return pycode;
    }

    public void setPycode(String pycode) {
        this.pycode = pycode;
    }

    public BigDecimal getSex() {
        return sex;
    }

    public void setSex(BigDecimal sex) {
        this.sex = sex;
    }

    public BigDecimal getAge() {
        return age;
    }

    public void setAge(BigDecimal age) {
        this.age = age;
    }

    public BigDecimal getAgeunitcode() {
        return ageunitcode;
    }

    public void setAgeunitcode(BigDecimal ageunitcode) {
        this.ageunitcode = ageunitcode;
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

    public BigDecimal getOrderusercode() {
        return orderusercode;
    }

    public void setOrderusercode(BigDecimal orderusercode) {
        this.orderusercode = orderusercode;
    }

    public Date getSigntime() {
        return signtime;
    }

    public void setSigntime(Date signtime) {
        this.signtime = signtime;
    }

    public BigDecimal getSignusercode() {
        return signusercode;
    }

    public void setSignusercode(BigDecimal signusercode) {
        this.signusercode = signusercode;
    }

    public BigDecimal getTestcount() {
        return testcount;
    }

    public void setTestcount(BigDecimal testcount) {
        this.testcount = testcount;
    }

    public String getCardnum() {
        return cardnum;
    }

    public void setCardnum(String cardnum) {
        this.cardnum = cardnum;
    }

    public String getMedicalcardnum() {
        return medicalcardnum;
    }

    public void setMedicalcardnum(String medicalcardnum) {
        this.medicalcardnum = medicalcardnum;
    }

    public BigDecimal getUnitcode() {
        return unitcode;
    }

    public void setUnitcode(BigDecimal unitcode) {
        this.unitcode = unitcode;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getWorktype() {
        return worktype;
    }

    public void setWorktype(String worktype) {
        this.worktype = worktype;
    }

    public String getSelfnum() {
        return selfnum;
    }

    public void setSelfnum(String selfnum) {
        this.selfnum = selfnum;
    }

    public String getJobnum() {
        return jobnum;
    }

    public void setJobnum(String jobnum) {
        this.jobnum = jobnum;
    }

    public String getTesttype() {
        return testtype;
    }

    public void setTesttype(String testtype) {
        this.testtype = testtype;
    }

    public String getPeisnum() {
        return peisnum;
    }

    public void setPeisnum(String peisnum) {
        this.peisnum = peisnum;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    public BigDecimal getBoxcode() {
        return boxcode;
    }

    public void setBoxcode(BigDecimal boxcode) {
        this.boxcode = boxcode;
    }

    public String getBoxname() {
        return boxname;
    }

    public void setBoxname(String boxname) {
        this.boxname = boxname;
    }

    public String getBatchno() {
        return batchno;
    }

    public void setBatchno(String batchno) {
        this.batchno = batchno;
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPostno() {
        return postno;
    }

    public void setPostno(String postno) {
        this.postno = postno;
    }

    public String getAbo() {
        return abo;
    }

    public void setAbo(String abo) {
        this.abo = abo;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getSsno() {
        return ssno;
    }

    public void setSsno(String ssno) {
        this.ssno = ssno;
    }

    public String getHealthcardnum() {
        return healthcardnum;
    }

    public void setHealthcardnum(String healthcardnum) {
        this.healthcardnum = healthcardnum;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getRecordtime() {
        return recordtime;
    }

    public void setRecordtime(Date recordtime) {
        this.recordtime = recordtime;
    }

    public BigDecimal getRecordusercode() {
        return recordusercode;
    }

    public void setRecordusercode(BigDecimal recordusercode) {
        this.recordusercode = recordusercode;
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    public BigDecimal getModifyusercode() {
        return modifyusercode;
    }

    public void setModifyusercode(BigDecimal modifyusercode) {
        this.modifyusercode = modifyusercode;
    }

    public String getPhotoid() {
        return photoid;
    }

    public void setPhotoid(String photoid) {
        this.photoid = photoid;
    }

    public String getSignid() {
        return signid;
    }

    public void setSignid(String signid) {
        this.signid = signid;
    }

    public BigDecimal getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(BigDecimal statuscode) {
        this.statuscode = statuscode;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }

    public Short getCheckbox() {
        return checkbox;
    }

    public void setCheckbox(Short checkbox) {
        this.checkbox = checkbox;
    }

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Date getFirstTestTime() {
		return firstTestTime;
	}

	public void setFirstTestTime(Date firstTestTime) {
		this.firstTestTime = firstTestTime;
	}

	public Date getFinishTestTime() {
		return finishTestTime;
	}

	public void setFinishTestTime(Date finishTestTime) {
		this.finishTestTime = finishTestTime;
	}

	public Date getTotalTestTime() {
		return totalTestTime;
	}

	public void setTotalTestTime(Date totalTestTime) {
		this.totalTestTime = totalTestTime;
	}

	public Date getReportPrintTime() {
		return reportPrintTime;
	}

	public void setReportPrintTime(Date reportPrintTime) {
		this.reportPrintTime = reportPrintTime;
	}

	public Date getGetReportTime() {
		return getReportTime;
	}

	public void setGetReportTime(Date getReportTime) {
		this.getReportTime = getReportTime;
	}

	public String getHealthExamNo() {
		return healthExamNo;
	}

	public void setHealthExamNo(String healthExamNo) {
		this.healthExamNo = healthExamNo;
	}

	public String getRespDoctorName() {
		return respDoctorName;
	}

	public void setRespDoctorName(String respDoctorName) {
		this.respDoctorName = respDoctorName;
	}

	public String getRespDoctorId() {
		return respDoctorId;
	}

	public void setRespDoctorId(String respDoctorId) {
		this.respDoctorId = respDoctorId;
	}

	public Date getHealthExamDate() {
		return healthExamDate;
	}

	public void setHealthExamDate(Date healthExamDate) {
		this.healthExamDate = healthExamDate;
	}
    
	public String getpID() {
		return pID;
	}

	public void setpID(String pID) {
		this.pID = pID;
	}

	public String getAgeUnit() {
		return ageUnit;
	}

	public void setAgeUnit(String ageUnit) {
		this.ageUnit = ageUnit;
	}

	public String getBedNum() {
		return bedNum;
	}

	public void setBedNum(String bedNum) {
		this.bedNum = bedNum;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getsFName() {
		return sFName;
	}

	public void setsFName(String sFName) {
		this.sFName = sFName;
	}

	public String getsFCode() {
		return sFCode;
	}

	public void setsFCode(String sFCode) {
		this.sFCode = sFCode;
	}

	public String getsFMoney() {
		return sFMoney;
	}

	public void setsFMoney(String sFMoney) {
		this.sFMoney = sFMoney;
	}

	public String getsFCount() {
		return sFCount;
	}

	public void setsFCount(String sFCount) {
		this.sFCount = sFCount;
	}

	public String getsFTime() {
		return sFTime;
	}

	public void setsFTime(String sFTime) {
		this.sFTime = sFTime;
	}

	public String getfPH() {
		return fPH;
	}

	public void setfPH(String fPH) {
		this.fPH = fPH;
	}

	public String getLczd() {
		return lczd;
	}

	public void setLczd(String lczd) {
		this.lczd = lczd;
	}

	public String getPatType() {
		return patType;
	}

	public void setPatType(String patType) {
		this.patType = patType;
	}

	public String getHisID() {
		return hisID;
	}

	public void setHisID(String hisID) {
		this.hisID = hisID;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public String getLisbz() {
		return lisbz;
	}

	public void setLisbz(String lisbz) {
		this.lisbz = lisbz;
	}
	
	public String getSexStr() {
		return sexStr;
	}

	public void setSexStr(String sexStr) {
		this.sexStr = sexStr;
	}

	public String getPresentaddr() {
		return presentaddr;
	}

	public void setPresentaddr(String presentaddr) {
		this.presentaddr = presentaddr;
	}

	public String getSsstyle() {
		return ssstyle;
	}

	public void setSsstyle(String ssstyle) {
		this.ssstyle = ssstyle;
	}

	public String getCommunity() {
		return community;
	}

	public void setCommunity(String community) {
		this.community = community;
	}

	public String getAreaname() {
		return areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}

	public String getExamtype() {
		return examtype;
	}

	public void setExamtype(String examtype) {
		this.examtype = examtype;
	}

	public String getAreaHisCode() {
		return areaHisCode;
	}

	public void setAreaHisCode(String areaHisCode) {
		this.areaHisCode = areaHisCode;
	}

}
    