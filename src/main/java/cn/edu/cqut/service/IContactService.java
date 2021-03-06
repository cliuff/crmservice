package cn.edu.cqut.service;

import cn.edu.cqut.entity.Contact;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CQUT SE 2020
 * @since 2020-06-08
 */
public interface IContactService extends IService<Contact> {
	
public List<Contact> getContactByCusNo(String cusNo);

public List<Contact> getContactByCtName(String ctName,String cusNo);
}
