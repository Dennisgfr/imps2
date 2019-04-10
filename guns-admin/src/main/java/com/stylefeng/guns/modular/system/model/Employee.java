package com.stylefeng.guns.modular.system.model;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 员工信息表
 * </p>
 *
 * @author gfr123
 * @since 2019-04-10
 */
@TableName("imps_employee")
public class Employee extends Model<Employee> {

    private static final long serialVersionUID = 1L;

    /**
     * 员工编号
     */
    private String ygbh;
    private String ygxm;
    /**
     * 员工性别
     */
    private String ygxb;
    /**
     * 身份证
     */
    private String sfz;
    /**
     * 员工籍贯
     */
    private String ygjg;
    /**
     * 员工名族
     */
    private String ygmz;
    /**
     * 工作部门
     */
    private String gzbm;
    /**
     * 入职时间
     */
    private Date rzsj;
    /**
     * 电话
     */
    private String ygdh;
    /**
     * 工作内容
     */
    private String gznr;
    /**
     * 银行卡号
     */
    private String yhkh;
    /**
     * 职务
     */
    private String zw;


    public String getYgbh() {
        return ygbh;
    }

    public void setYgbh(String ygbh) {
        this.ygbh = ygbh;
    }

    public String getYgxm() {
        return ygxm;
    }

    public void setYgxm(String ygxm) {
        this.ygxm = ygxm;
    }

    public String getYgxb() {
        return ygxb;
    }

    public void setYgxb(String ygxb) {
        this.ygxb = ygxb;
    }

    public String getSfz() {
        return sfz;
    }

    public void setSfz(String sfz) {
        this.sfz = sfz;
    }

    public String getYgjg() {
        return ygjg;
    }

    public void setYgjg(String ygjg) {
        this.ygjg = ygjg;
    }

    public String getYgmz() {
        return ygmz;
    }

    public void setYgmz(String ygmz) {
        this.ygmz = ygmz;
    }

    public String getGzbm() {
        return gzbm;
    }

    public void setGzbm(String gzbm) {
        this.gzbm = gzbm;
    }

    public Date getRzsj() {
        return rzsj;
    }

    public void setRzsj(Date rzsj) {
        this.rzsj = rzsj;
    }

    public String getYgdh() {
        return ygdh;
    }

    public void setYgdh(String ygdh) {
        this.ygdh = ygdh;
    }

    public String getGznr() {
        return gznr;
    }

    public void setGznr(String gznr) {
        this.gznr = gznr;
    }

    public String getYhkh() {
        return yhkh;
    }

    public void setYhkh(String yhkh) {
        this.yhkh = yhkh;
    }

    public String getZw() {
        return zw;
    }

    public void setZw(String zw) {
        this.zw = zw;
    }

    @Override
    protected Serializable pkVal() {
        return this.ygbh;
    }

    @Override
    public String toString() {
        return "Employee{" +
        "ygbh=" + ygbh +
        ", ygxm=" + ygxm +
        ", ygxb=" + ygxb +
        ", sfz=" + sfz +
        ", ygjg=" + ygjg +
        ", ygmz=" + ygmz +
        ", gzbm=" + gzbm +
        ", rzsj=" + rzsj +
        ", ygdh=" + ygdh +
        ", gznr=" + gznr +
        ", yhkh=" + yhkh +
        ", zw=" + zw +
        "}";
    }
}
