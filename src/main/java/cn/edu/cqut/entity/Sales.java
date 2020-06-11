package cn.edu.cqut.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author CQUT SE 2020
 * @since 2020-06-10
 */
public class Sales extends Model<Sales> {

    private static final long serialVersionUID=1L;

    @TableId("orderNo")
    private Integer orderNo;

    @TableField("orderCustomerNo")
    private String orderCustomerNo;

    @TableField("orderSalesmanNo")
    private Integer orderSalesmanNo;

    @TableField("orderAmount")
    private Double orderAmount;

    @TableField("orderTime")
    private String orderTime;


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

    public Integer getOrderSalesmanNo() {
        return orderSalesmanNo;
    }

    public void setOrderSalesmanNo(Integer orderSalesmanNo) {
        this.orderSalesmanNo = orderSalesmanNo;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
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
        ", orderSalesmanNo=" + orderSalesmanNo +
        ", orderAmount=" + orderAmount +
        ", orderTime=" + orderTime +
        "}";
    }
}
