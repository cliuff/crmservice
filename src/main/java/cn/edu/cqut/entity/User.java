package cn.edu.cqut.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 
 * </p>
 *
 * @author CQUT SE 2020
 * @since 2020-06-09
 */
public class User extends Model<User> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    
    @TableField("count_no")
    private String countNo;
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("user_name")
    private String userName;
    
    @TableField("pwd")
    private String pwd;
    
    @TableField("tel")
    private String tel;
    
    @TableField("work_status")
    private String workStatus;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountNo() {
        return countNo;
    }

    public void setCountNo(String countNo) {
        this.countNo = countNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "User{" +
        "id=" + id +
        ", countNo=" + countNo +
        ", userName=" + userName +
        ", pwd=" + pwd +
        ", tel=" + tel +
        ", workStatus=" + workStatus +
        "}";
    }
}
