package cn.edu.cqut.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.edu.cqut.service.IContactService;
import cn.edu.cqut.service.ICustomerService;
import cn.edu.cqut.util.CrmResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Arrays;
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
	private String cusNo1;
	    private final IContactService contactService;
	    @Autowired
	    public ContactController(IContactService contactService) {
	        this.contactService = contactService;
	    }

	// 通过CusNo获取到联系人列表
	@RequestMapping(value = "/getContactByCusNo", method = RequestMethod.POST)
	public CrmResult<Contact> getContactByCusNo( @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "2") Integer limit,

	Contact contact) {
		QueryWrapper<Contact> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("cusNo", contact.getCusNo());//第二个cusNo是前台对应where中的数值
		
		  if (contact.getCtName() != null) {
			  queryWrapper.like("ctName", contact.getCtName()); //第一个参数是字段名
	        }
			
		
		
		Page<Contact> page2 = contactService.page(new Page<Contact>(page, limit), queryWrapper);

	
		CrmResult<Contact> ret = new CrmResult<>();
		ret.setCode(0);
		ret.setCount(page2.getTotal());
		ret.setData(page2.getRecords());
		return ret;
		
	}

	
	@RequestMapping("/updateContact")
	public CrmResult<Contact> updateCustomer(Contact contact) {
		contactService.updateById(contact); // 根据主键更新表

		CrmResult<Contact> ret = new CrmResult<>();
		ret.setCode(0);
		ret.setMsg("更新客户成功");
		return ret;
	}

	@RequestMapping("/addContact")
	public CrmResult<Contact> addContact(Contact contact) {
		String s = contact.getCusNo();
		/* System.out.print("添加联系人的客户编号"+s); */

		contactService.save(contact);

		CrmResult<Contact> ret = new CrmResult<>();
		ret.setCode(0);
		ret.setMsg("新增联系人成功");
		return ret;
	}

	@RequestMapping("/delContact")
	public CrmResult<Contact> delContacts(String[] ids) {
		contactService.removeByIds(Arrays.asList(ids));
		CrmResult<Contact> ret = new CrmResult<>();
		ret.setCode(0);
		ret.setMsg("删除联系人成功");
		return ret;
	}

	@RequestMapping("/lookContactByctName")
	public CrmResult<Contact> delContacts(String ctName, String cusNo) {
		System.out.print("查询联系人的姓名" + ctName);
		System.out.print("查询联系人的客户编号" + cusNo);
		List<Contact> contacts = contactService.getContactByCtName(ctName, cusNo);

		long count = (long) contacts.size();
		Long counts = (Long) count;
		CrmResult<Contact> ret = new CrmResult<>();
		ret.setCode(0);
		ret.setMsg("查询联系人成功");
		ret.setCount(counts);
		ret.setData(contacts); // 这页的数据列表
		return ret;
	}

}
