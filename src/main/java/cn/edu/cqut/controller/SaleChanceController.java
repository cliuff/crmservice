package cn.edu.cqut.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.edu.cqut.entity.Customer;
import cn.edu.cqut.entity.SaleChance;
import cn.edu.cqut.service.ICustomerService;
import cn.edu.cqut.service.ISaleChanceService;
import cn.edu.cqut.util.CrmResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author CQUT SE 2020
 * @since 2020-06-09
 */
@RestController
@RequestMapping("/saleChance")
@CrossOrigin
public class SaleChanceController {
	 @Autowired
	    private ISaleChanceService salechanceservice;

	    @ApiOperation(value = "分页返回客户信息12456",
	            notes = "分页查询客户信息，默认返回第一页，每页10行。还可以根据cusName模糊查询")
	    @RequestMapping(value = "/saleChances", method = RequestMethod.POST)
	    public CrmResult<SaleChance> getAllSaleChance(
	            @ApiParam(value = "要查询的页码", required = true)
	            @RequestParam(defaultValue = "1")
	                    Integer page, //page请求的页码,默认为1
	            @ApiParam(value = "每页的行数", required = true)
	            @RequestParam(defaultValue = "10")
	                    Integer limit,//limit每页的行数，默认为10
	            SaleChance salechance) {
	        QueryWrapper<SaleChance> qw = new QueryWrapper<>();
	        if (salechance.getSaleChanceId() != null) {
	            qw.like("saleChanceId", salechance.getSaleChanceId()); //第一个参数是字段名
	        }
	        Page<SaleChance> pageSaleChance = salechanceservice.page(
	                new Page<>(page, limit), qw);

	        CrmResult<SaleChance> ret = new CrmResult<>();
	        ret.setCode(0);
	        ret.setMsg("");
	        ret.setCount(pageSaleChance.getTotal());//表里的记录总数
	        ret.setData(pageSaleChance.getRecords()); //这页的数据列表
	        return ret;
	    }
	        @ApiIgnore
	        @RequestMapping("/updateSaleChance")
	        public CrmResult<SaleChance> updateSaleChance(SaleChance salechance) {
	            salechanceservice.updateById(salechance);  //根据主键更新表

	            CrmResult<SaleChance> ret = new CrmResult<>();
	            ret.setCode(0);
	            ret.setMsg("更新销售机会成功");
	            return ret;
	        }

	        @ApiIgnore
	        @RequestMapping("/addSaleChance")
	        public CrmResult<SaleChance> addCustomer(SaleChance salechance) {
	            salechanceservice.save(salechance);

	            CrmResult<SaleChance> ret = new CrmResult<>();
	            ret.setCode(0);
	            ret.setMsg("新增客户成功");
	            return ret;
	        }

	        @ApiIgnore
	        @RequestMapping("/delSaleChance")
	        public CrmResult<SaleChance> delCustomer(String[] ids) {
	            salechanceservice.removeByIds(Arrays.asList(ids));

	            CrmResult<SaleChance> ret = new CrmResult<>();
	            ret.setCode(0);
	            ret.setMsg("删除客户成功");
	            return ret;
	        }
	    
}

