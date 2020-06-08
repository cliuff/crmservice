package cn.edu.cqut.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author CQUT SE 2020
 * @since 2020-06-08
 */
public class Customer extends Model<Customer> {

    private static final long serialVersionUID=1L;

    @TableId("cusNo")
    private Integer cusNo;

    @TableField("cusName")
    private String cusName;

    @TableField("cusRegion")
    private String cusRegion;

    @TableField("cusAddr")
    private String cusAddr;

    @TableField("cusUrl")
    private String cusUrl;

    @TableField("cusLevel")
    private String cusLevel;

    @TableField("cusCredit")
    private String cusCredit;


    public Integer getCusNo() {
        return cusNo;
    }

    public void setCusNo(Integer cusNo) {
        this.cusNo = cusNo;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusRegion() {
        return cusRegion;
    }

    public void setCusRegion(String cusRegion) {
        this.cusRegion = cusRegion;
    }

    public String getCusAddr() {
        return cusAddr;
    }

    public void setCusAddr(String cusAddr) {
        this.cusAddr = cusAddr;
    }

    public String getCusUrl() {
        return cusUrl;
    }

    public void setCusUrl(String cusUrl) {
        this.cusUrl = cusUrl;
    }

    public String getCusLevel() {
        return cusLevel;
    }

    public void setCusLevel(String cusLevel) {
        this.cusLevel = cusLevel;
    }

    public String getCusCredit() {
        return cusCredit;
    }

    public void setCusCredit(String cusCredit) {
        this.cusCredit = cusCredit;
    }

    @Override
    protected Serializable pkVal() {
        return this.cusNo;
    }

    @Override
    public String toString() {
        return "Customer{" +
        "cusNo=" + cusNo +
        ", cusName=" + cusName +
        ", cusRegion=" + cusRegion +
        ", cusAddr=" + cusAddr +
        ", cusUrl=" + cusUrl +
        ", cusLevel=" + cusLevel +
        ", cusCredit=" + cusCredit +
        "}";
    }
}
