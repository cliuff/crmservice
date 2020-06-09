package cn.edu.cqut.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author CQUT SE 2020
 * @since 2020-06-09
 */
public class SaleChance extends Model<SaleChance> {

    private static final long serialVersionUID=1L;

    @TableId("sale_Chance_Id")
    private Integer saleChanceId;

    @TableField("cusName")
    private String cusName;

    @TableField("sale_Source")
    private String saleSource;

    private String success;

    private String profile;

    private String descript;

    @TableField("createPerson")
    private String createPerson;

    @TableField("createTime")
    private LocalDateTime createTime;

    private String assign;

    @TableField("assignTime")
    private LocalDateTime assignTime;

    @TableField("saleChanceState")
    private String saleChanceState;


    public Integer getSaleChanceId() {
        return saleChanceId;
    }

    public void setSaleChanceId(Integer saleChanceId) {
        this.saleChanceId = saleChanceId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getSaleSource() {
        return saleSource;
    }

    public void setSaleSource(String saleSource) {
        this.saleSource = saleSource;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getAssign() {
        return assign;
    }

    public void setAssign(String assign) {
        this.assign = assign;
    }

    public LocalDateTime getAssignTime() {
        return assignTime;
    }

    public void setAssignTime(LocalDateTime assignTime) {
        this.assignTime = assignTime;
    }

    public String getSaleChanceState() {
        return saleChanceState;
    }

    public void setSaleChanceState(String saleChanceState) {
        this.saleChanceState = saleChanceState;
    }

    @Override
    protected Serializable pkVal() {
        return this.saleChanceId;
    }

    @Override
    public String toString() {
        return "SaleChance{" +
        "saleChanceId=" + saleChanceId +
        ", cusName=" + cusName +
        ", saleSource=" + saleSource +
        ", success=" + success +
        ", profile=" + profile +
        ", descript=" + descript +
        ", createPerson=" + createPerson +
        ", createTime=" + createTime +
        ", assign=" + assign +
        ", assignTime=" + assignTime +
        ", saleChanceState=" + saleChanceState +
        "}";
    }
}
