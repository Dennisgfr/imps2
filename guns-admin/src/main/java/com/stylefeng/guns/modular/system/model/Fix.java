package com.stylefeng.guns.modular.system.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 室内维修记录表
 * </p>
 *
 * @author gfr123
 * @since 2019-04-10
 */
@TableName("imps_fix")
public class Fix extends Model<Fix> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 房间编号
     */
    private String fjbh;
    /**
     * 业主姓名
     */
    private String yzxm;
    /**
     * 业主电话
     */
    private String yzdh;
    /**
     * 维修项目
     */
    private String wxxm;
    /**
     * 维修日期
     */
    private Date wxrq;
    /**
     * 维修人编号
     */
    private String wxrybh;
    /**
     * 维修人姓名
     */
    private String wxrxm;
    /**
     * 业主评价
     */
    private String yzpj;
    /**
     * 备注
     */
    private String bz;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFjbh() {
        return fjbh;
    }

    public void setFjbh(String fjbh) {
        this.fjbh = fjbh;
    }

    public String getYzxm() {
        return yzxm;
    }

    public void setYzxm(String yzxm) {
        this.yzxm = yzxm;
    }

    public String getYzdh() {
        return yzdh;
    }

    public void setYzdh(String yzdh) {
        this.yzdh = yzdh;
    }

    public String getWxxm() {
        return wxxm;
    }

    public void setWxxm(String wxxm) {
        this.wxxm = wxxm;
    }

    public Date getWxrq() {
        return wxrq;
    }

    public void setWxrq(Date wxrq) {
        this.wxrq = wxrq;
    }

    public String getWxrybh() {
        return wxrybh;
    }

    public void setWxrybh(String wxrybh) {
        this.wxrybh = wxrybh;
    }

    public String getWxrxm() {
        return wxrxm;
    }

    public void setWxrxm(String wxrxm) {
        this.wxrxm = wxrxm;
    }

    public String getYzpj() {
        return yzpj;
    }

    public void setYzpj(String yzpj) {
        this.yzpj = yzpj;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Fix{" +
        "id=" + id +
        ", fjbh=" + fjbh +
        ", yzxm=" + yzxm +
        ", yzdh=" + yzdh +
        ", wxxm=" + wxxm +
        ", wxrq=" + wxrq +
        ", wxrybh=" + wxrybh +
        ", wxrxm=" + wxrxm +
        ", yzpj=" + yzpj +
        ", bz=" + bz +
        "}";
    }
}
