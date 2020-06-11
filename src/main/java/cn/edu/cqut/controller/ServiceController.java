package cn.edu.cqut.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import cn.edu.cqut.entity.Contact;
import cn.edu.cqut.entity.Customer;
import cn.edu.cqut.entity.User;
import cn.edu.cqut.service.ICustomerService;
import cn.edu.cqut.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.edu.cqut.entity.CustomerService;
import cn.edu.cqut.service.ServiceService;
import cn.edu.cqut.util.CrmResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/service")
@CrossOrigin
@Api(tags = "服务客户管理")
public class ServiceController {

	@Autowired
	private ServiceService serviceService;

	@Autowired
	private ICustomerService customerService;

	@Autowired
	private IUserService userService;

	    @ApiOperation(value = "分页返回服务信息",
	            notes = "分页查询服务信息，默认返回第一页，每页10行。还可以模糊查询")
	    @RequestMapping(value = "/services")
	    public CrmResult<CustomerService> getAllCustomer(
	            @ApiParam(value = "要查询的页码", required = true)
	            @RequestParam(defaultValue = "1")
	                    Integer page, //page请求的页码,默认为1
	            @ApiParam(value = "每页的行数", required = true)
	            @RequestParam(defaultValue = "10")
	                    Integer limit,//limit每页的行数，默认为10
	                    CustomerService service) {
	        QueryWrapper<CustomerService> qw = new QueryWrapper<>();
	        if (service.getServiceType() != null) {
	            qw.like("service_type", service.getServiceType()); //第一个参数是字段名
				qw.or();
				qw.like("id", service.getServiceType());
	        }
	        Page<CustomerService> pageService = serviceService.page(
	                new Page<>(page, limit), qw);

	        CrmResult<CustomerService> ret = new CrmResult<>();
	        ret.setCode(0);
	        ret.setMsg("");
	        ret.setCount(pageService.getTotal());//表里的记录总数
	        ret.setData(pageService.getRecords()); //这页的数据列表
	        return ret;
	    }

	@ApiOperation(value = "分页返回服务信息通过服务状态",
			notes = "分页查询服务信息通过服务状态，默认返回第一页，每页10行。还可以模糊查询")
	@RequestMapping(value = "/servicesByServiceStatus")
	public CrmResult<CustomerService> getAllCustomerByServiceStatus(
			@ApiParam(value = "要查询的页码", required = true)
			@RequestParam(defaultValue = "1")
					Integer page, //page请求的页码,默认为1
			@ApiParam(value = "每页的行数", required = true)
			@RequestParam(defaultValue = "10")
					Integer limit,//limit每页的行数，默认为10
			CustomerService service) {
		QueryWrapper<CustomerService> qw = new QueryWrapper<>();

		if (service.getHandler() != null) {
			qw.eq("handler", service.getHandler()); //第一个参数是字段名
		}

		if (service.getServiceStatus() != null) {
			qw.like("service_status", service.getServiceStatus()); //第一个参数是字段名

		}

		if (service.getServiceType() != null) {
			qw.like("service_type", service.getServiceType()); //第一个参数是字段名
			qw.or();
			qw.like("customer_id", service.getServiceType());

		}


		Page<CustomerService> pageService = serviceService.page(
				new Page<>(page, limit), qw);

		CrmResult<CustomerService> ret = new CrmResult<>();
		ret.setCode(0);
		ret.setMsg("");
		ret.setCount(pageService.getTotal());//表里的记录总数
		ret.setData(pageService.getRecords()); //这页的数据列表
		return ret;
	}

		// 获取所有客户
		@RequestMapping(value = "/getAllCustomer", method = RequestMethod.POST)
		public List<Customer> getAllCustomer() {
			List<Customer> customerLists = customerService.getAllCustomer();

			return customerLists;

		}

	// 获取所有经理
	@RequestMapping(value = "/getUserByRole", method = RequestMethod.POST)
	public List<User> getUserByRole() {
		List<User> userLists = userService.getUserByRole();

		return userLists;

	}

	    @ApiIgnore
	    @RequestMapping("/updateService")
	    public CrmResult<CustomerService> updateService(CustomerService service) {
	        serviceService.updateById(service);  //根据主键更新表
	        CrmResult<CustomerService> ret = new CrmResult<>();
	        ret.setCode(0);
	        ret.setMsg("更新服务成功");
	        return ret;
	    }



		@ApiIgnore
		@RequestMapping(value = "/updateServiceAllocate",method = RequestMethod.POST)
		public CrmResult<CustomerService> updateServiceAllocate(CustomerService service) {
	    	service.setAllocateTime(new Date());
			serviceService.updateById(service);  //根据主键更新表
			CrmResult<CustomerService> ret = new CrmResult<>();
			ret.setCode(0);
			ret.setMsg("更新服务成功");
			return ret;
		}

	@ApiIgnore
	@RequestMapping(value = "/updateServiceHandle",method = RequestMethod.POST)
	public CrmResult<CustomerService> updateServiceHandle(CustomerService service) {
		service.setHandleTime(new Date());
		serviceService.updateById(service);  //根据主键更新表
		CrmResult<CustomerService> ret = new CrmResult<>();
		ret.setCode(0);
		ret.setMsg("更新服务成功");
		return ret;
	}


		@ApiIgnore
		@RequestMapping(value = "/updateServiceFacebook",method = RequestMethod.POST)
		public CrmResult<CustomerService> updateServiceFacebook(CustomerService service) {
			if(service.getSatisfaction()== 1 || service.getSatisfaction()== 2){
				service.setHandleMethod("[客户满意度不够,需重新处理]" + service.getHandleMethod());
				service.setHandleResult("[客户满意度不够,需重新处理]" + service.getHandleResult());
				service.setServiceStatus("已分配");
			}else{
				service.setServiceStatus("已归档");
			}
			serviceService.updateById(service);  //根据主键更新表
			CrmResult<CustomerService> ret = new CrmResult<>();
			ret.setCode(0);
			ret.setMsg("更新服务成功");
			return ret;
		}

	    @ApiIgnore
	    @RequestMapping("/addService")
	    public CrmResult<CustomerService> addService(CustomerService service) {
	    	service.setServiceStatus("新创建");
	    	service.setCreateTime(new Date());
	    	serviceService.save(service);
	        CrmResult<CustomerService> ret = new CrmResult<>();
	        ret.setCode(0);
	        ret.setMsg("新增服务成功");
	        return ret;
	    }

	    @ApiIgnore
	    @RequestMapping("/delService")
	    public CrmResult<CustomerService> delService(String[] ids) {
	    	serviceService.removeByIds(Arrays.asList(ids));

	        CrmResult<CustomerService> ret = new CrmResult<>();
	        ret.setCode(0);
	        ret.setMsg("删除服务成功");
	        return ret;
	    }

}
