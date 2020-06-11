package cn.edu.cqut.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
 * @since 2020-06-09
 */
@Controller
@RequestMapping("/customerPlan")
public class CustomerPlanController {
	@Autowired
    private ICustomerPlanService customerplanservice;

    @ApiOperation(value = "分页返回客户信息12456",
            notes = "分页查询客户信息，默认返回第一页，每页10行。还可以根据cusName模糊查询")
    @RequestMapping(value = "/customerPlans", method = RequestMethod.POST)
    public CrmResult<CustomerPlan> getAllCustomerPlan(
            @ApiParam(value = "要查询的页码", required = true)
            @RequestParam(defaultValue = "1")
                    Integer page, //page请求的页码,默认为1
            @ApiParam(value = "每页的行数", required = true)
            @RequestParam(defaultValue = "10")
                    Integer limit,//limit每页的行数，默认为10
            CustomerPlan customerplan) {
        QueryWrapper<CustomerPlan> qw = new QueryWrapper<>();
        if ("妮子".equals(customerplan.getUserName())) {
            qw.like("saleChanceState", salechance.getSaleChanceState()); //第一个参数是字段名
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

        @RequestMapping("/assignSaleChance")
        public CrmResult<SaleChance> assignSaleChance(SaleChance salechance) {
        	salechance.setAssignTime(LocalDate.now());
        	salechance.setSaleChanceState("已分配");
            salechanceservice.updateById(salechance);  //根据主键更新表
            CrmResult<SaleChance> ret = new CrmResult<>();
            ret.setCode(0);
            ret.setMsg("更新销售机会成功");
            return ret;
        }

        
        @ApiIgnore
        @RequestMapping("/addSaleChance")
        public CrmResult<SaleChance> addSaleChance(SaleChance salechance) {
        	salechance.setCreateTime(LocalDate.now());
        	salechance.setSaleChanceState("未分配");
            salechanceservice.save(salechance);

            CrmResult<SaleChance> ret = new CrmResult<>();
            ret.setCode(0);
            ret.setMsg("新增客户成功");
            return ret;
        }

        @ApiIgnore
        @RequestMapping("/delSaleChance")
        public CrmResult<SaleChance> delSaleChance(String[] ids) {
            salechanceservice.removeByIds(Arrays.asList(ids));
            
            CrmResult<SaleChance> ret = new CrmResult<>();
            ret.setCode(0);
            ret.setMsg("删除客户成功");
            return ret;
        }
    
}


