package cn.edu.cqut.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import io.swagger.annotations.ApiModelProperty;

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
public class Sales extends Model<Sales> {

    private static final long serialVersionUID=1L;

    
    @TableId("orderNo")
    private Integer orderNo;

    @TableField("orderCustomerNo")
    private String orderCustomerNo;

    @TableField("orderSalesNo")
    private Integer orderSalesNo;

    @TableField("orderAmount")
    private Double orderAmount;

    @TableField("orderTime")
    private Long orderTime;


    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderCustomerNo() {
        return orderCustomerNo;
    }

    public void setOrderCustomerNo(String orderCustomerNo) {
        this.orderCustomerNo = orderCustomerNo;
    }

    public Integer getOrderSalesNo() {
        return orderSalesNo;
    }

    public void setOrderSalesNo(Integer orderSalesNo) {
        this.orderSalesNo = orderSalesNo;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Long getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Long orderTime) {
        this.orderTime = orderTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.orderNo;
    }

    @Override
    public String toString() {
        return "Sales{" +
        "orderNo=" + orderNo +
        ", orderCustomerNo=" + orderCustomerNo +
        ", orderSalesNo=" + orderSalesNo +
        ", orderAmount=" + orderAmount +
        ", orderTime=" + orderTime +
        "}";
    }
}
