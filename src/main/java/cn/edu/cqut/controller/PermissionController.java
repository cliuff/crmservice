package cn.edu.cqut.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.edu.cqut.entity.Menu;
import cn.edu.cqut.entity.Permission;
import cn.edu.cqut.service.IMenuService;
import cn.edu.cqut.service.IPermissionService;
import cn.edu.cqut.util.CrmResult;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Arrays;
import java.util.Date;

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
@RequestMapping("/permission")
public class PermissionController {
	 @Autowired
	    private IPermissionService iPermissionService;

	    @RequestMapping(value = "/search")
	    public CrmResult<Permission> getAllPermission(
	            @ApiParam(value = "要查询的页码", required = true)
	            @RequestParam(defaultValue = "1")
	                    Integer page, //page请求的页码,默认为1
	            @ApiParam(value = "每页的行数", required = true)
	            @RequestParam(defaultValue = "8")
	                    Integer limit,//limit每页的行数，默认为10
	            Permission permission) {
	    	
	        QueryWrapper<Permission> qw = new QueryWrapper<>();
	        
	        if (permission.getPermission() != null) {
	            qw.like("permission", permission.getPermission());
	        }
	        
	        Page<Permission> pagePermission = iPermissionService.page(
	                new Page<>(page, limit), qw);

	        CrmResult<Permission> ret = new CrmResult<>();
	        ret.setCode(0);
	        ret.setMsg("");
	        ret.setCount(pagePermission.getTotal());//表里的记录总数
	        ret.setData(pagePermission.getRecords()); //这页的数据列表
	        return ret;
	    }
	    
	    
	    @ApiIgnore
	    @RequestMapping("/update")
	    public CrmResult<Permission> updatePermission(Permission permission) {
	        iPermissionService.updateById(permission);  //根据主键更新表

	        CrmResult<Permission> ret = new CrmResult<>();
	        ret.setCode(0);
	        ret.setMsg("更新权限成功");
	        return ret;
	    }
	    
	    @ApiIgnore
	    @RequestMapping("/add")
	    public CrmResult<Permission> addPermission(Permission permission) {
	    	permission.setCreateTime(new Date());
	    	
	    	iPermissionService.save(permission);

	        CrmResult<Permission> ret = new CrmResult<>();
	        ret.setCode(0);
	        ret.setMsg("新增权限成功");
	        return ret;
	    }

	    @ApiIgnore
	    @RequestMapping("/del")
	    public CrmResult<Permission> delPermission(String[] ids) {
	        iPermissionService.removeByIds(Arrays.asList(ids));

	        CrmResult<Permission> ret = new CrmResult<>();
	        ret.setCode(0);
	        ret.setMsg("删除成功");
	        return ret;
	    }
}

