package cn.edu.cqut.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotation.TableId;
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
public class CustomerPlan extends Model<CustomerPlan> {

    private static final long serialVersionUID=1L;

    @TableId("cusPlanId")
    private Integer cusPlanId;

    @TableField("time")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate time;

    @TableId("context")
    private String context;

    @TableId("result")
    private String result;
    
    private String UserName;

    @TableField("sale_Chance_Id")
    private Integer saleChanceId;


    public Integer getCusPlanId() {
        return cusPlanId;
    }

    public void setCusPlanId(Integer cusPlanId) {
        this.cusPlanId = cusPlanId;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Integer getSaleChanceId() {
        return saleChanceId;
    }

    public void setSaleChanceId(Integer saleChanceId) {
        this.saleChanceId = saleChanceId;
    }

    @Override
    protected Serializable pkVal() {
        return this.cusPlanId;
    }

    @Override
    public String toString() {
        return "CustomerPlan{" +
        "cusPlanId=" + cusPlanId +
        ", time=" + time +
        ", context=" + context +
        ", result=" + result +
        ", saleChanceId=" + saleChanceId +
        "}";
    }
}
