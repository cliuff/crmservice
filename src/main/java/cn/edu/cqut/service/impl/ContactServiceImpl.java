package cn.edu.cqut.service.impl;

import cn.edu.cqut.entity.Contact;
import cn.edu.cqut.mapper.ContactMapper;
import cn.edu.cqut.service.IContactService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author CQUT SE 2020
 * @since 2020-06-08
 */
@Service
public class ContactServiceImpl extends ServiceImpl<ContactMapper, Contact> implements IContactService {

	@Override
	public List<Contact> getContactByCusNo(String cusNo) {
		// TODO Auto-generated method stub
		return baseMapper.selectContactByCusNo(cusNo);
	}

	@Override
	public List<Contact> getContactByCtName(String ctName,String cusNo) {
		// TODO Auto-generated method stub
		return baseMapper.selectContactByCtName(ctName,cusNo);
	}
	
	

}
