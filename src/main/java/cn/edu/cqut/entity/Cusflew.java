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
 * @since 2020-06-11
 */
public class Cusflew extends Model<Cusflew> {

    private static final long serialVersionUID=1L;

    @TableId("cfNo")
    private String cfNo;

    @TableField("cusNo")
    private String cusNo;
    
    @TableField("cusName")
    private String cusName;

    @TableField("cfMes")
    private String cfMes;

    @TableField("cfState")
    private String cfState;


    public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getCfNo() {
        return cfNo;
    }

    public void setCfNo(String cfNo) {
        this.cfNo = cfNo;
    }

    public String getCusNo() {
        return cusNo;
    }

    public void setCusNo(String cusNo) {
        this.cusNo = cusNo;
    }

    public String getCfMes() {
        return cfMes;
    }

    public void setCfMes(String cfMes) {
        this.cfMes = cfMes;
    }

    public String getCfState() {
        return cfState;
    }

    public void setCfState(String cfState) {
        this.cfState = cfState;
    }

    @Override
    protected Serializable pkVal() {
        return this.cfNo;
    }

    @Override
    public String toString() {
        return "Cusflew{" +
        "cfNo=" + cfNo +
        ", cusNo=" + cusNo +
        ", cfMes=" + cfMes +
        ", cfState=" + cfState +
        "}";
    }
}
