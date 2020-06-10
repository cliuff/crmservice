package cn.edu.cqut.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.edu.cqut.entity.Customer;
import cn.edu.cqut.entity.Record;
import cn.edu.cqut.service.ICustomerService;
import cn.edu.cqut.service.IRecordService;
import cn.edu.cqut.util.CrmResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author CQUT SE 2020
 * @since 2020-06-10
 */
@RestController
@CrossOrigin
@RequestMapping("/record")
public class RecordController {
	
	private final IRecordService recordService;

    @Autowired
    public RecordController(IRecordService recordService) {
        this.recordService = recordService;
    }

    @ApiOperation(value = "分页返回客户信息12456",
            notes = "分页查询客户信息，默认返回第一页，每页10行。还可以根据cusName模糊查询")
    @RequestMapping(value = "/getAllRecords", method = RequestMethod.POST)
    public CrmResult<Record> getAllRecords(
            @ApiParam(value = "要查询的页码", required = true)
            @RequestParam(defaultValue = "1")
                    Integer page, //page请求的页码,默认为1
            @ApiParam(value = "每页的行数", required = true)
            @RequestParam(defaultValue = "10")
                    Integer limit,//limit每页的行数，默认为10
            Record record) {
    	
		/* recordService.selectRecordswithCusName(page, queryWrapper); */
    	
        QueryWrapper<Record> qw = new QueryWrapper<>();
        if (record.getCusName() != null) {
            qw.like("cusName",record.getCusName()); //第一个参数是字段名
        }
        Page<Record> pageRecords = new Page<>(page, limit);
        recordService.selectRecordswithCusName(pageRecords, qw);
        CrmResult<Record> ret = new CrmResult<>();
        ret.setCode(0);
        ret.setMsg("");
        ret.setCount(pageRecords.getTotal());//表里的记录总数
        ret.setData(pageRecords.getRecords()); //这页的数据列表
        return ret;
    }
	

}

