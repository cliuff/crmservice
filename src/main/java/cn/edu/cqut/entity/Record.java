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
 * @since 2020-06-10
 */
public class Record extends Model<Record> {

    private static final long serialVersionUID=1L;

    @TableId("rNo")
    private String rNo;

    @TableField("cusNo")
    private String cusNo;

    @TableField("rDate")
    private LocalDateTime rDate;

    @TableField("rAddr")
    private String rAddr;

    @TableField("rDesc")
    private String rDesc;

    @TableField("rRemark")
    private String rRemark;
    
    @TableField(exist = false)
    private String cusName;
  
    public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getrNo() {
        return rNo;
    }

    public void setrNo(String rNo) {
        this.rNo = rNo;
    }

    public String getCusNo() {
        return cusNo;
    }

    public void setCusNo(String cusNo) {
        this.cusNo = cusNo;
    }

    public LocalDateTime getrDate() {
        return rDate;
    }

    public void setrDate(LocalDateTime rDate) {
        this.rDate = rDate;
    }

    public String getrAddr() {
        return rAddr;
    }

    public void setrAddr(String rAddr) {
        this.rAddr = rAddr;
    }

    public String getrDesc() {
        return rDesc;
    }

    public void setrDesc(String rDesc) {
        this.rDesc = rDesc;
    }

    public String getrRemark() {
        return rRemark;
    }

    public void setrRemark(String rRemark) {
        this.rRemark = rRemark;
    }

    @Override
    protected Serializable pkVal() {
        return this.rNo;
    }

    @Override
    public String toString() {
        return "Record{" +
        "rNo=" + rNo +
        ", cusNo=" + cusNo +
        ", rDate=" + rDate +
        ", rAddr=" + rAddr +
        ", rDesc=" + rDesc +
        ", rRemark=" + rRemark +
        "}";
    }
}
