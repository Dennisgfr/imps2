package com.stylefeng.guns.modular.system.model;

import java.io.Serializable;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 房屋信息表
 * </p>
 *
 * @author gfr123
 * @since 2019-04-10
 */
@TableName("imps_room")
public class Room extends Model<Room> {

    private static final long serialVersionUID = 1L;

    /**
     * 房间编号
     */
    private String fjbh;
    /**
     * 所属大楼编号
     */
    private String shdl;
    /**
     * 单元号
     */
    private String dyh;
    /**
     * 楼层号
     */
    private Integer lch;
    /**
     * 房间号
     */
    private String fjh;
    /**
     * 房型
     */
    private String fx;
    /**
     * 建筑面积
     */
    private BigDecimal jzmj;
    /**
     * 使用面积
     */
    private BigDecimal symj;
    /**
     * 简要说明
     */
    private String jysm;
    /**
     * 装修情况
     */
    private String zxqk;
    /**
     * 业主编号
     */
    private String yzbh;


    public String getFjbh() {
        return fjbh;
    }

    public void setFjbh(String fjbh) {
        this.fjbh = fjbh;
    }

    public String getShdl() {
        return shdl;
    }

    public void setShdl(String shdl) {
        this.shdl = shdl;
    }

    public String getDyh() {
        return dyh;
    }

    public void setDyh(String dyh) {
        this.dyh = dyh;
    }

    public Integer getLch() {
        return lch;
    }

    public void setLch(Integer lch) {
        this.lch = lch;
    }

    public String getFjh() {
        return fjh;
    }

    public void setFjh(String fjh) {
        this.fjh = fjh;
    }

    public String getFx() {
        return fx;
    }

    public void setFx(String fx) {
        this.fx = fx;
    }

    public BigDecimal getJzmj() {
        return jzmj;
    }

    public void setJzmj(BigDecimal jzmj) {
        this.jzmj = jzmj;
    }

    public BigDecimal getSymj() {
        return symj;
    }

    public void setSymj(BigDecimal symj) {
        this.symj = symj;
    }

    public String getJysm() {
        return jysm;
    }

    public void setJysm(String jysm) {
        this.jysm = jysm;
    }

    public String getZxqk() {
        return zxqk;
    }

    public void setZxqk(String zxqk) {
        this.zxqk = zxqk;
    }

    public String getYzbh() {
        return yzbh;
    }

    public void setYzbh(String yzbh) {
        this.yzbh = yzbh;
    }

    @Override
    protected Serializable pkVal() {
        return this.fjbh;
    }

    @Override
    public String toString() {
        return "Room{" +
        "fjbh=" + fjbh +
        ", shdl=" + shdl +
        ", dyh=" + dyh +
        ", lch=" + lch +
        ", fjh=" + fjh +
        ", fx=" + fx +
        ", jzmj=" + jzmj +
        ", symj=" + symj +
        ", jysm=" + jysm +
        ", zxqk=" + zxqk +
        ", yzbh=" + yzbh +
        "}";
    }
}
