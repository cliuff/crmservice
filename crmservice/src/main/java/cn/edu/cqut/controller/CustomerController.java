package cn.edu.cqut.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.edu.cqut.entity.Customer;
import cn.edu.cqut.service.ICustomerService;
import cn.edu.cqut.util.CrmResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器，连接前台（前台数据访问的接口）
 * </p>
 * 要运行一下MpGenerator.java文件
 *方法是用的springMVC
 *cotroller--service(业务层)--dao层（mybatis中的）
 * @author HQYJ
 * @since 2020-06-03
<<<<<<< HEAD
 */
@RestController
@RequestMapping("/customer")//在网页上直接输localhost:8080/customer/customers（前台对应的customerList.html中的url）,查看数据内容
@CrossOrigin//跨域请求机制
@Api(tags = "客户管理")
public class CustomerController {
	@Autowired //spring自动给service赋值（容器中的对象）控制层去访问service层要加入注解
	private ICustomerService customerService;//从后台数据表中获取的数据的方法应该是封装在Service里面的
	
	@ApiOperation(value = "分页返回客户信息",
			notes = "分页查询客户信息，默认返回第一页，每页10行。还可以根据cusName模糊查询")
	
	@RequestMapping(value="/customer",method=RequestMethod.POST)//要被前端访问，应该加入注解RequestMapping ，（前台对应的customerUpdate.html中的url）
	public CrmResult<Customer> getAllCustomer(
			@ApiParam(value = "要查询的页码",required = true)
			@RequestParam(defaultValue = "1") 
			Integer page, //page请求的页码,默认为1
			@ApiParam(value = "每页的行数",required = true)
			@RequestParam(defaultValue = "10") 
			Integer limit,//limit每页的行数，默认为10
			Customer customer){ 
		QueryWrapper<Customer> qw = new QueryWrapper<>();
		if(customer.getCusName()!=null) {
			qw.like("cusName", customer.getCusName()); //第一个参数是字段名
		}
		Page<Customer> pageCustomer = customerService.page(
				new Page<Customer>(page,limit), qw);
		
		CrmResult<Customer> ret = new CrmResult<>();
		ret.setCode(0);
		ret.setMsg("");
		ret.setCount(pageCustomer.getTotal());//表里的记录总数
		ret.setData(pageCustomer.getRecords()); //这页的数据列表
		return ret;
	}
	
	@ApiIgnore
	@RequestMapping("/addCustomer")
	public CrmResult<Customer> addCustomer(Customer customer){
		customerService.save(customer);//添加客户
		CrmResult<Customer> ret = new CrmResult<>();
		ret.setCode(0);
		ret.setMsg("新增客户成功");
		return ret;
	}
	
	@ApiIgnore
	@RequestMapping("/delCustomer")
	public CrmResult<Customer> delCustomer(String[] ids){//这里的ids要与前台的ids相同
		customerService.removeByIds(Arrays.asList(ids));//添加客户,将数组转化为list
		CrmResult<Customer> ret = new CrmResult<>();
		ret.setCode(0);
		ret.setMsg("删除客户成功");
		return ret;
	}
	
	@ApiIgnore
	@RequestMapping("/updateCustomer")
	public CrmResult<Customer> updateCustomer(Customer customer){
		customerService.updateById(customer);  //根据主键更新表
		
		CrmResult<Customer> ret = new CrmResult<>();
		ret.setCode(0);
		ret.setMsg("更新客户成功");
=======
 * 在线生成文档
 * swagger（
 * api
 * apiOperation
 * apiParam
 * apiModel
 * apiModelProperty
 * ）
 */

@RestController
@RequestMapping("/customer")//在网页上直接输localhost:8080/customer/customers（前台对应的customerList.html中的url）,查看数据内容
@CrossOrigin//跨域请求机制
@Api(tags="客户管理")//注明哪个接口
public class CustomerController {
	@Autowired //spring自动给service赋值（容器中的对象）控制层去访问service层要加入注解
	private ICustomerService customerService;//从后台数据表中获取的数据的方法应该是封装在Service里面的
	
	@ApiOperation(value = "分页返回客户信息",
			notes = "分页查询客户信息，默认返回第一页，每页10行。还可以根据cusName模糊查询")
	@RequestMapping(value = "/customers",method=RequestMethod.POST ) //要被前端访问，应该加入注解RequestMapping ，（前台对应的customerUpdate.html中的url），Post表示生成在线接口文档时方法的类型
	public CrmResult<Customer> getAllCustomer(
			
			@ApiParam(value="要查询的页码",required=true)
			@RequestParam(defaultValue = "1") 
			Integer page, //page请求的页码,默认为1
			
			@ApiParam(value="每页的行数",required=true)
			@RequestParam(defaultValue = "5") 
			Integer limit, //rows每页的行数，默认为10
			
			Customer customer){//用实体类来接收前台数据
		QueryWrapper<Customer> qw=new QueryWrapper<>();
		if(customer.getCusName()!=null) {
			qw.like("cusName", customer.getCusName());//第一个参数是数据库中对应的字段名
		}
		
		Page<Customer> pageCustomer = customerService.page(new Page<Customer>(page,limit),qw);
		
		//把数据表中的数据赋值给前台的json，自动计算页数
		CrmResult<Customer> ret = new CrmResult<>();
		ret.setCode(0);
		ret.setMsg("");
		ret.setCount(pageCustomer.getTotal());//表里的记录总数
		ret.setData(pageCustomer.getRecords()); //这页的数据列表
		return ret;
	}
	@ApiIgnore
	@RequestMapping("/updateCustomer")
	public CrmResult<Customer> updateCustomer(Customer customer){
		customerService.updateById(customer);//根据主键更新表
		CrmResult<Customer> ret = new CrmResult<>();
		ret.setCode(0);
		ret.setMsg("更新客户成功");
		return ret;//返回一个json对象
	}
	
	@ApiIgnore
	@RequestMapping("/addCustomer")
	public CrmResult<Customer> addCustomer(Customer customer){
		customerService.save(customer);//添加客户
		CrmResult<Customer> ret = new CrmResult<>();
		ret.setCode(0);
		ret.setMsg("新增客户成功");
		return ret;
	}
	
	@ApiIgnore
	@RequestMapping("/delCustomer")
	public CrmResult<Customer> delCustomer(String[] ids){//这里的ids要与前台的ids相同
		customerService.removeByIds(Arrays.asList(ids));//添加客户,将数组转化为list
		CrmResult<Customer> ret = new CrmResult<>();
		ret.setCode(0);
		ret.setMsg("删除客户成功");
>>>>>>> branch 'master' of https://github.com/cliuff/crmservice.git
		return ret;
	}
	
	
}

