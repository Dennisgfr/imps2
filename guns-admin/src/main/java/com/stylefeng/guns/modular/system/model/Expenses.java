package com.stylefeng.guns.modular.system.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 业主收费管理表
 * </p>
 *
 * @author gfr123
 * @since 2019-04-12
 */
@TableName("imps_expense")
public class Expenses extends Model<Expenses> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String yzxm;
    /**
     * 费用月份
     */
    private Date fyyf;
    /**
     * 费用项目
     */
    private String fyxm;
    /**
     * 费用金额
     */
    private BigDecimal fyje;
    /**
     * 滞纳金
     */
    private BigDecimal znj;
    /**
     * 应缴金额
     */
    private BigDecimal yjje;
    /**
     * 滞纳金起计
     */
    private Date znjqj;
    /**
     * 滞纳金截止
     */
    private Date znjjz;
    /**
     * 实交金额
     */
    private BigDecimal sjje;
    /**
     * 审核人
     */
    private String shr;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYzxm() {
        return yzxm;
    }

    public void setYzxm(String yzxm) {
        this.yzxm = yzxm;
    }

    public Date getFyyf() {
        return fyyf;
    }

    public void setFyyf(Date fyyf) {
        this.fyyf = fyyf;
    }

    public String getFyxm() {
        return fyxm;
    }

    public void setFyxm(String fyxm) {
        this.fyxm = fyxm;
    }

    public BigDecimal getFyje() {
        return fyje;
    }

    public void setFyje(BigDecimal fyje) {
        this.fyje = fyje;
    }

    public BigDecimal getZnj() {
        return znj;
    }

    public void setZnj(BigDecimal znj) {
        this.znj = znj;
    }

    public BigDecimal getYjje() {
        return yjje;
    }

    public void setYjje(BigDecimal yjje) {
        this.yjje = yjje;
    }

    public Date getZnjqj() {
        return znjqj;
    }

    public void setZnjqj(Date znjqj) {
        this.znjqj = znjqj;
    }

    public Date getZnjjz() {
        return znjjz;
    }

    public void setZnjjz(Date znjjz) {
        this.znjjz = znjjz;
    }

    public BigDecimal getSjje() {
        return sjje;
    }

    public void setSjje(BigDecimal sjje) {
        this.sjje = sjje;
    }

    public String getShr() {
        return shr;
    }

    public void setShr(String shr) {
        this.shr = shr;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Expenses{" +
        "id=" + id +
        ", yzxm=" + yzxm +
        ", fyyf=" + fyyf +
        ", fyxm=" + fyxm +
        ", fyje=" + fyje +
        ", znj=" + znj +
        ", yjje=" + yjje +
        ", znjqj=" + znjqj +
        ", znjjz=" + znjjz +
        ", sjje=" + sjje +
        ", shr=" + shr +
        "}";
    }
}
