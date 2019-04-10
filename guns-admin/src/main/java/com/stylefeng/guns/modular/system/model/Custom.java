package com.stylefeng.guns.modular.system.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 业主信息表
 * </p>
 *
 * @author gfr123
 * @since 2019-04-10
 */
@TableName("imps_custom")
public class Custom extends Model<Custom> {

    private static final long serialVersionUID = 1L;

    /**
     * 业主姓名
     */
    private String yzxm;
    /**
     * 业主编号 
     */
    private String yzbh;
    /**
     * 性别
     */
    private String xb;
    /**
     * 业主籍贯
     */
    private String jg;
    /**
     * 证件类型
     */
    private String zjlx;
    /**
     * 证件号码
     */
    private String zjhm;
    /**
     * 业主电话
     */
    private String yzdh;
    /**
     * 业主居住楼层
     */
    private String yzjulc;
    /**
     * 业主居住房间号
     */
    private String yzjzfjh;


    public String getYzxm() {
        return yzxm;
    }

    public void setYzxm(String yzxm) {
        this.yzxm = yzxm;
    }

    public String getYzbh() {
        return yzbh;
    }

    public void setYzbh(String yzbh) {
        this.yzbh = yzbh;
    }

    public String getXb() {
        return xb;
    }

    public void setXb(String xb) {
        this.xb = xb;
    }

    public String getJg() {
        return jg;
    }

    public void setJg(String jg) {
        this.jg = jg;
    }

    public String getZjlx() {
        return zjlx;
    }

    public void setZjlx(String zjlx) {
        this.zjlx = zjlx;
    }

    public String getZjhm() {
        return zjhm;
    }

    public void setZjhm(String zjhm) {
        this.zjhm = zjhm;
    }

    public String getYzdh() {
        return yzdh;
    }

    public void setYzdh(String yzdh) {
        this.yzdh = yzdh;
    }

    public String getYzjulc() {
        return yzjulc;
    }

    public void setYzjulc(String yzjulc) {
        this.yzjulc = yzjulc;
    }

    public String getYzjzfjh() {
        return yzjzfjh;
    }

    public void setYzjzfjh(String yzjzfjh) {
        this.yzjzfjh = yzjzfjh;
    }

    @Override
    protected Serializable pkVal() {
        return this.yzbh;
    }

    @Override
    public String toString() {
        return "Custom{" +
        "yzxm=" + yzxm +
        ", yzbh=" + yzbh +
        ", xb=" + xb +
        ", jg=" + jg +
        ", zjlx=" + zjlx +
        ", zjhm=" + zjhm +
        ", yzdh=" + yzdh +
        ", yzjulc=" + yzjulc +
        ", yzjzfjh=" + yzjzfjh +
        "}";
    }
}
