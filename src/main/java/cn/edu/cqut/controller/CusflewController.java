package cn.edu.cqut.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.edu.cqut.entity.Cusflew;
import cn.edu.cqut.entity.Customer;
import cn.edu.cqut.service.ICusflewService;
import cn.edu.cqut.service.ICustomerService;
import cn.edu.cqut.util.CrmResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author CQUT SE 2020
 * @since 2020-06-11
 */
@RestController
@CrossOrigin
@RequestMapping("/cusflew")
public class CusflewController {
	private final ICusflewService cusflewService;

	@Autowired
	public CusflewController(ICusflewService cusflewService) {
		this.cusflewService = cusflewService;
	}

	@RequestMapping(value = "/getCusFlews", method = RequestMethod.POST)
	public CrmResult<Cusflew> getCusFlews(
			@ApiParam(value = "要查询的页码", required = true) @RequestParam(defaultValue = "1") Integer page, // page请求的页码,默认为1
			@ApiParam(value = "每页的行数", required = true) @RequestParam(defaultValue = "10") Integer limit, // limit每页的行数，默认为10
			Cusflew cusflew) {
		QueryWrapper<Cusflew> qw = new QueryWrapper<>();
		if (cusflew.getCusName() != null) {
			qw.like("cusName", cusflew.getCusName()); // 第一个参数是字段名
		}
		Page<Cusflew> pageCustomer = cusflewService.page(new Page<>(page, limit), qw);

		CrmResult<Cusflew> ret = new CrmResult<>();
		ret.setCode(0);
		ret.setMsg("");
		ret.setCount(pageCustomer.getTotal());// 表里的记录总数
		ret.setData(pageCustomer.getRecords()); // 这页的数据列表
		return ret;
	}

	// 每天凌晨3点触发一次,将超过6个月没下单的客户加入预警流失名单
	 @Scheduled(cron = "0 0 3 ? * *") //0 27 13 ? * *:表示每天13点27分触发一次
	public void job()
	 {
		 
		List<Cusflew> cusflews = new ArrayList<>();
		
		// 获取超过6个月没下单的客户信息（获取客户编号）
		List<Customer> customers = cusflewService.getOrCustomersOverSixMonths();
		System.out.print("姓名：" + cusflewService.getOrCustomersOverSixMonths().get(0));

		for (int i = 0; i < customers.size(); i++) {
			String cfId = UUID.randomUUID().toString().replace("_", "").substring(0, 4);// 随机生成长度为4的字符串
			Cusflew cusflew = new Cusflew();

			cusflew.setCfNo(cfId);
			cusflew.setCusNo(customers.get(i).getCusNo());
			cusflew.setCusName(customers.get(i).getCusName());
			cusflew.setCfState("流失预警");

			if (cusflew.getCfNo() != null) {
				if (!cusflewService.isExitCusNo(cusflew.getCfNo()))
				// 如果cusflew表中不含订单表cusNo对应的值,则将此条数据添加到cusflews中（加到cusflew数据库中）
				{
					cusflews.add(cusflew);
				}
			}
		}

		if (!cusflews.isEmpty()) {
			cusflewService.saveBatch(cusflews);
		}
	}


	//暂缓流失
	  @ApiIgnore 
	  @RequestMapping("/doDeferFlow") 
	  public CrmResult<Cusflew> doDeferFlow(Cusflew cusflew)
	  { 
		  cusflew.setCfState("暂缓流失");
		  cusflewService.updateById(cusflew);
		  
	  //根据主键更新表
	  CrmResult<Cusflew> ret = new CrmResult<>(); 
	  ret.setCode(0);
	  ret.setMsg("");
	  return ret;
	  
	  }

	  //确定流失
	  @ApiIgnore 
	  @RequestMapping("/confirmFlow") 
	  public CrmResult<Cusflew> confirmFlow(Cusflew cusflew)
	  { 
		  cusflew.setCfState("确定流失");
		  cusflewService.updateById(cusflew);
		  
	  //根据主键更新表
	  CrmResult<Cusflew> ret = new CrmResult<>(); 
	  ret.setCode(0);
	  ret.setMsg("");
	  return ret;
	  
	  }
	 
	  @RequestMapping("/delCusFlew")
	    public CrmResult<Cusflew> delCusFlew(String[] ids) {
		  System.out.println("要删除的流失编号为"+ids[0]);
	        cusflewService.removeByIds(Arrays.asList(ids));

	        CrmResult<Cusflew> ret = new CrmResult<>();
	        ret.setCode(0);
	        ret.setMsg("删除流失记录成功");
	        return ret;
	    }

}
