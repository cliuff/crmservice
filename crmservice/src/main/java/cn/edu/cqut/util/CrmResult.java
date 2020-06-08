package cn.edu.cqut.util;

import java.util.List;

import cn.edu.cqut.entity.Customer;
//与前台的demo.json里的字段相对应
public class CrmResult<T> {
	private Integer code;
	private String msg;
	private Long count;
	private List<T> data;
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	
}
