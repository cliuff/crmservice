package cn.edu.cqut.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.edu.cqut.entity.CustomerPlan;
import cn.edu.cqut.entity.SaleChance;
import cn.edu.cqut.service.ICustomerPlanService;
import cn.edu.cqut.service.ISaleChanceService;
import cn.edu.cqut.util.CrmResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author CQUT SE 2020
 * @since 2020-06-11
 */
@RestController
@RequestMapping("/customerPlan")
@CrossOrigin
public class CustomerPlanController {
	@Autowired
    private ICustomerPlanService customerplanservice;

    @ApiOperation(value = "分页返回客户信息12456",
            notes = "分页查询客户信息，默认返回第一页，每页10行。")
    @RequestMapping(value = "/CustomerPlans", method = RequestMethod.POST)
    public CrmResult<CustomerPlan> getAllCustomerPlan(
            @ApiParam(value = "要查询的页码", required = true)
            @RequestParam(defaultValue = "1")
                    Integer page, //page请求的页码,默认为1
            @ApiParam(value = "每页的行数", required = true)
            @RequestParam(defaultValue = "10")
                    Integer limit,//limit每页的行数，默认为10
            CustomerPlan customerplan) {
        QueryWrapper<CustomerPlan> qw = new QueryWrapper<>();
        if (customerplan.getSaleChanceId()!=null) {
            qw.eq("sale_Chance_Id", customerplan.getSaleChanceId()); //第一个参数是字段名
        }
        Page<CustomerPlan> pageCustomerPlan = customerplanservice.page(
                new Page<>(page, limit), qw);

        CrmResult<CustomerPlan> ret = new CrmResult<>();
        ret.setCode(0);
        ret.setMsg("");
        ret.setCount(pageCustomerPlan.getTotal());//表里的记录总数
        ret.setData(pageCustomerPlan.getRecords()); //这页的数据列表
        return ret;
    }
        @ApiIgnore
        @RequestMapping("/updateCustomerPlan")
        public CrmResult<CustomerPlan> updateSaleChance(CustomerPlan customerplan) {
        	customerplanservice.updateById(customerplan);  //根据主键更新表
            CrmResult<CustomerPlan> ret = new CrmResult<>();
            ret.setCode(0);
            ret.setMsg("更新开发计划成功");
            return ret;
        }

        
        @ApiIgnore
        @RequestMapping("/addCustomerPlan")
        public CrmResult<CustomerPlan> addSaleChance(CustomerPlan customerplan) {
        	
        	customerplan.setResult("未完成");
        	customerplan.setUserName("妮子");
        	customerplan.setSaleChanceId(1016);
        	

            CrmResult<CustomerPlan> ret = new CrmResult<>();
            ret.setCode(0);
            ret.setMsg("新增计划成功");
            return ret;
        }

        @ApiIgnore
        @RequestMapping("/delCustomerPlan")
        public CrmResult<SaleChance> delSaleChance(String[] ids) {
            customerplanservice.removeByIds(Arrays.asList(ids));
            
            CrmResult<SaleChance> ret = new CrmResult<>();
            ret.setCode(0);
            ret.setMsg("删除计划成功");
            return ret;
        }
    
}


