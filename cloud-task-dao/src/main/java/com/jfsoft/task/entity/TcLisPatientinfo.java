
package com.jfsoft.task.entity;

import java.util.Date;

/**
 * Lis体检人员信息
 * 
 * @author wanggang
 * @version 1.0 2017-06-29
 */
public class TcLisPatientinfo {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 医院编号
     */
    private String hospitalCode;

    /**
     * 患者ID
     */
    private Integer patinfoid;

    /**
     * 检查日期
     */
    private Date testdate;

    /**
     * 患者姓名
     */
    private String name;

    /**
     * 姓名拼音码
     */
    private String pycode;

    /**
     * 性别
     */
    private String sex;

    /**
     * 年龄
     */
    private String age;

    /**
     * 年龄单位
     */
    private String ageunit;

    /**
     * 床号
     */
    private String bednum;

    /**
     * 住院号
     */
    private String pid;

    /**
     * 科室名称
     */
    private String dptname;

    /**
     * 医生名称
     */
    private String dctname;

    /**
     * 患者类型
     */
    private String pattype;

    /**
     * 临床诊断
     */
    private String lczd;

    /**
     * 条码号
     */
    private String barcode;

    /**
     * 备注
     */
    private String memo;

    /**
     * 登记时间
     */
    private Date regname;

    /**
     * 收费项目
     */
    private String feename;

    /**
     * 检验类型
     */
    private String testtype;

    /**
     * 检验者
     */
    private String testopt;

    /**
     * 审核者
     */
    private String checkopt;

    /**
     * 审核时间(显示在微信报告单上)
     */
    private Date checkTime;

    /**
     * 检查时间
     */
    private Date checkdate;

    /**
     * 打印者
     */
    private String printopt;

    /**
     * 打印时间
     */
    private String printdate;

    /**
     * 打印状态
     */
    private String printstate;

    /**
     * 区域代码
     */
    private String areacode;

    /**
     * 报告单路径
     */
    private String filepath;

    /**
     * 预留字段
     */
    private String reserve1;

    /**
     * 预留字段
     */
    private String reserve2;

    /**
     * 预留字段
     */
    private String reserve3;

    /**
     * 预留字段
     */
    private String reserve4;

    /**
     * 联系电话
     */
    private String tel;

    /**
     * 备份
     */
    private String lisinfo;

    /**
     * base64
     */
    private String pic;

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

    public Integer getPatinfoid() {
        return patinfoid;
    }

    public void setPatinfoid(Integer patinfoid) {
        this.patinfoid = patinfoid;
    }

    public Date getTestdate() {
        return testdate;
    }

    public void setTestdate(Date testdate) {
        this.testdate = testdate;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }

    public String getAgeunit() {
        return ageunit;
    }

    public void setAgeunit(String ageunit) {
        this.ageunit = ageunit == null ? null : ageunit.trim();
    }

    public String getBednum() {
        return bednum;
    }

    public void setBednum(String bednum) {
        this.bednum = bednum == null ? null : bednum.trim();
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getDptname() {
        return dptname;
    }

    public void setDptname(String dptname) {
        this.dptname = dptname == null ? null : dptname.trim();
    }

    public String getDctname() {
        return dctname;
    }

    public void setDctname(String dctname) {
        this.dctname = dctname == null ? null : dctname.trim();
    }

    public String getPattype() {
        return pattype;
    }

    public void setPattype(String pattype) {
        this.pattype = pattype == null ? null : pattype.trim();
    }

    public String getLczd() {
        return lczd;
    }

    public void setLczd(String lczd) {
        this.lczd = lczd == null ? null : lczd.trim();
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode == null ? null : barcode.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public Date getRegname() {
        return regname;
    }

    public void setRegname(Date regname) {
        this.regname = regname;
    }

    public String getFeename() {
        return feename;
    }

    public void setFeename(String feename) {
        this.feename = feename == null ? null : feename.trim();
    }

    public String getTesttype() {
        return testtype;
    }

    public void setTesttype(String testtype) {
        this.testtype = testtype == null ? null : testtype.trim();
    }

    public String getTestopt() {
        return testopt;
    }

    public void setTestopt(String testopt) {
        this.testopt = testopt == null ? null : testopt.trim();
    }

    public String getCheckopt() {
        return checkopt;
    }

    public void setCheckopt(String checkopt) {
        this.checkopt = checkopt == null ? null : checkopt.trim();
    }

    public Date getCheckdate() {
        return checkdate;
    }

    public void setCheckdate(Date checkdate) {
        this.checkdate = checkdate;
    }

    public String getPrintopt() {
        return printopt;
    }

    public void setPrintopt(String printopt) {
        this.printopt = printopt == null ? null : printopt.trim();
    }

    public String getPrintdate() {
        return printdate;
    }

    public void setPrintdate(String printdate) {
        this.printdate = printdate == null ? null : printdate.trim();
    }

    public String getPrintstate() {
        return printstate;
    }

    public void setPrintstate(String printstate) {
        this.printstate = printstate == null ? null : printstate.trim();
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode == null ? null : areacode.trim();
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath == null ? null : filepath.trim();
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getLisinfo() {
        return lisinfo;
    }

    public void setLisinfo(String lisinfo) {
        this.lisinfo = lisinfo;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

}
