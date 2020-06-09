package cn.edu.cqut.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.edu.cqut.service.IContactService;
import cn.edu.cqut.util.CrmResult;
import io.swagger.annotations.ApiParam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cn.edu.cqut.entity.Contact;
import cn.edu.cqut.entity.Customer;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author CQUT SE 2020
 * @since 2020-06-08
 */
@RestController
@CrossOrigin
@RequestMapping("/contact")
public class ContactController {
	private String cusNo;
	@Autowired
	private IContactService contactService;

	// 通过CusNo获取到联系人列表
	@RequestMapping(value = "/getContactByCusNo", method = RequestMethod.POST)
	public List<Contact> getContactByCusNo(String cusNo) {
		System.out.println("cusNo is:" + cusNo);
		List<Contact> contactLists = contactService.getContactByCusNo(cusNo);
		this.cusNo = cusNo;

		return contactLists;

		/* return contactService.getContactByCusNo(cusNo); */

	}

	 @RequestMapping(value = "/contactsByCusNo"/*, method = RequestMethod.POST*/)
	public CrmResult<Contact> getAllContactsByCusNo(
			@ApiParam(value = "要查询的页码", required = true) @RequestParam(defaultValue = "1") Integer page, // page请求的页码,默认为1
			@ApiParam(value = "每页的行数", required = true) @RequestParam(defaultValue = "10") Integer limit// limit每页的行数，默认为10
	/* Customer customer */) {
		/*
		 * QueryWrapper<Customer> qw = new QueryWrapper<>(); if (customer.getCusName()
		 * != null) { qw.like("cusName", customer.getCusName()); //第一个参数是字段名 }
		 */
		List<Contact> contactLists = getContactByCusNo(cusNo);
        System.out.print(contactLists.size());
		long count = (long) contactLists.size();
		Long counts = (Long) count;

		CrmResult<Contact> ret = new CrmResult<>();
		ret.setCode(0);
		ret.setMsg("有联系人");
		ret.setCount(counts);// 表里的记录总数
		ret.setData(contactLists); // 这页的数据列表
		return ret;
	}

}
