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
public class Contact extends Model<Contact> {

    private static final long serialVersionUID=1L;

    @TableId("ctId")
    private String ctId;

    @TableField("ctName")
    private String ctName;

    @TableField("ctGender")
    private String ctGender;

    @TableField("ctPhone")
    private String ctPhone;

    @TableField("ctTitle")
    private String ctTitle;


    @TableField("cusNo")
    private String cusNo;


    public String getCtId() {
        return ctId;
    }

    public void setCtId(String ctId) {
        this.ctId = ctId;
    }

    public String getCtName() {
        return ctName;
    }

    public void setCtName(String ctName) {
        this.ctName = ctName;
    }

    public String getCtGender() {
        return ctGender;
    }

    public void setCtGender(String ctGender) {
        this.ctGender = ctGender;
    }

    public String getCtPhone() {
        return ctPhone;
    }

    public void setCtPhone(String ctPhone) {
        this.ctPhone = ctPhone;
    }

    public String getCtTitle() {
        return ctTitle;
    }

    public void setCtTitle(String ctTitle) {
        this.ctTitle = ctTitle;
    }



    public String getCusNo() {
        return cusNo;
    }

    public void setCusNo(String cusNo) {
        this.cusNo = cusNo;
    }

    @Override
    protected Serializable pkVal() {
        return this.ctId;
    }

    @Override
    public String toString() {
        return "Contact{" +
        "ctId=" + ctId +
        ", ctName=" + ctName +
        ", ctGender=" + ctGender +
        ", ctPhone=" + ctPhone +
        ", ctTitle=" + ctTitle +
        ", cusNo=" + cusNo +
        "}";
    }
}
