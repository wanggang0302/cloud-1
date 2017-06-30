package com.jfsoft.peis.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 体检者检查组合项目表
 * @author wanggang
 * 2017年3月21日 上午10:26:52
 */
public class PerGroupitem {
	
    private String id;

    private String testno;
    /**
     * 体检号别名
     */
    private String hisCode;
    /**
     * 患者名称
     */
    private String name;
    /**
     * 身份证
     */
    private String identityCode;
    /**
     * 性别
     */
    private String sex;
    /**
     * 年龄
     */
    private int age;
    /**
     * 年龄单位
     */
    private String ageUnit;
    /**
     * 床号
     */
    private String bedNum;
    /**
     * 科室code
     */
    private String departmentId;
    /**
     * 医生code
     */
    private String doctorId;
    /**
     * 组合项目code
     */
    private String itemId;
    /**
     * 组合项目名称
     */
    private String itemName;
    /**
     * 收费项目单价
     */
    private Double itemPrice;
    /**
     * 申请时间
     */
    private String applyTime;
    
    /**
     * 诊断
     */
    private String disease;
    /**
     * 病人类型
     */
    private String patientType;
    /**
     * 急诊标志
     */
    private String samplestate;
    /**
     * 用药信息
     */
    private String drugmemo;
	/**
	 * 医嘱信息
	 */
    private String ordersmemo;
    /**
     * 所属机构id
     */
    private String posId ;
    
    
    public String getHisCode() {
		return hisCode;
	}

	public void setHisCode(String hisCode) {
		this.hisCode = hisCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdentityCode() {
		return identityCode;
	}

	public void setIdentityCode(String identityCode) {
		this.identityCode = identityCode;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}



	public String getPatientType() {
		return patientType;
	}

	public void setPatientType(String patientType) {
		this.patientType = patientType;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getSamplestate() {
		return samplestate;
	}

	public void setSamplestate(String samplestate) {
		this.samplestate = samplestate;
	}

	public String getDrugmemo() {
		return drugmemo;
	}

	public void setDrugmemo(String drugmemo) {
		this.drugmemo = drugmemo;
	}

	public String getOrdersmemo() {
		return ordersmemo;
	}

	public void setOrdersmemo(String ordersmemo) {
		this.ordersmemo = ordersmemo;
	}

	public String getPosId() {
		return posId;
	}

	public void setPosId(String posId) {
		this.posId = posId;
	}

	private BigDecimal groupcode;

    private String groupname;

    private String pycode;

    private Double groupmoney;

    private Double groupagiomoney;

    private Double discount;

    private String feeway;

    private BigDecimal statuscode;
    
    //组合状态名称
    private String statusname;

    private BigDecimal feestacode;

    private BigDecimal samplestacode;

    private BigDecimal breakfaststacode;

    private Date recordtime;

    private Date feetime;

    private Date refundtime;

    private Double refundmoney;

    private BigDecimal flag;

    private String perBillid;

    private String isoncredit;

    private String feeusername;

    private String refundusername;

    private String feereceiptid;

    private String refundreceiptid;

    private String areacode;
    /**
     * 项目组合的销售价
     */
    private Double sellmoney;
    /**
     * 项目组合的成本价
     */
    private Double costmoney;
    public Double getSellmoney() {
		return sellmoney;
	}

	public String getStatusname() {
		return statusname;
	}

	public void setStatusname(String statusname) {
		this.statusname = statusname;
	}

	public void setSellmoney(Double sellmoney) {
		this.sellmoney = sellmoney;
	}

	public Double getCostmoney() {
		return costmoney;
	}

	public void setCostmoney(Double costmoney) {
		this.costmoney = costmoney;
	}

	/**
    /**
     * 该组合项目所属科室编号
     */
    private String deptCode;
    
    /**
     * 该组合项目所属科室名称
     */
    private String deptName;

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

    public BigDecimal getGroupcode() {
        return groupcode;
    }

    public void setGroupcode(BigDecimal groupcode) {
        this.groupcode = groupcode;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getPycode() {
        return pycode;
    }

    public void setPycode(String pycode) {
        this.pycode = pycode;
    }

    public Double getGroupmoney() {
        return groupmoney;
    }

    public void setGroupmoney(Double groupmoney) {
        this.groupmoney = groupmoney;
    }

    public Double getGroupagiomoney() {
        return groupagiomoney;
    }

    public void setGroupagiomoney(Double groupagiomoney) {
        this.groupagiomoney = groupagiomoney;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getFeeway() {
        return feeway;
    }

    public void setFeeway(String feeway) {
        this.feeway = feeway;
    }

    public BigDecimal getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(BigDecimal statuscode) {
        this.statuscode = statuscode;
    }

    public BigDecimal getFeestacode() {
        return feestacode;
    }

    public void setFeestacode(BigDecimal feestacode) {
        this.feestacode = feestacode;
    }

    public BigDecimal getSamplestacode() {
        return samplestacode;
    }

    public void setSamplestacode(BigDecimal samplestacode) {
        this.samplestacode = samplestacode;
    }

    public BigDecimal getBreakfaststacode() {
        return breakfaststacode;
    }

    public void setBreakfaststacode(BigDecimal breakfaststacode) {
        this.breakfaststacode = breakfaststacode;
    }

    public Date getRecordtime() {
        return recordtime;
    }

    public void setRecordtime(Date recordtime) {
        this.recordtime = recordtime;
    }

    public Date getFeetime() {
        return feetime;
    }

    public void setFeetime(Date feetime) {
        this.feetime = feetime;
    }

    public Date getRefundtime() {
        return refundtime;
    }

    public void setRefundtime(Date refundtime) {
        this.refundtime = refundtime;
    }

    public Double getRefundmoney() {
        return refundmoney;
    }

    public void setRefundmoney(Double refundmoney) {
        this.refundmoney = refundmoney;
    }

    public BigDecimal getFlag() {
        return flag;
    }

    public void setFlag(BigDecimal flag) {
        this.flag = flag;
    }

    public String getPerBillid() {
        return perBillid;
    }

    public void setPerBillid(String perBillid) {
        this.perBillid = perBillid;
    }

    public String getIsoncredit() {
        return isoncredit;
    }

    public void setIsoncredit(String isoncredit) {
        this.isoncredit = isoncredit == null ? null : isoncredit.trim();
    }

    public String getFeeusername() {
        return feeusername;
    }

    public void setFeeusername(String feeusername) {
        this.feeusername = feeusername;
    }

    public String getRefundusername() {
        return refundusername;
    }

    public void setRefundusername(String refundusername) {
        this.refundusername = refundusername;
    }

    public String getFeereceiptid() {
        return feereceiptid;
    }

    public void setFeereceiptid(String feereceiptid) {
        this.feereceiptid = feereceiptid;
    }

    public String getRefundreceiptid() {
        return refundreceiptid;
    }

    public void setRefundreceiptid(String refundreceiptid) {
        this.refundreceiptid = refundreceiptid;
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
    
}
