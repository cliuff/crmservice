package cn.edu.cqut.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	            qw.like("serviceType", service.getServiceType()); //第一个参数是字段名
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
	    @RequestMapping("/addService")
	    public CrmResult<CustomerService> addService(CustomerService service) {
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
