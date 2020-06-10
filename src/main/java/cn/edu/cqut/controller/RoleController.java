package cn.edu.cqut.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.edu.cqut.entity.Role;
import cn.edu.cqut.entity.User;
import cn.edu.cqut.service.IRoleService;
import cn.edu.cqut.service.IUserService;
import cn.edu.cqut.util.CrmResult;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

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
@RequestMapping("/role")
public class RoleController {
	 @Autowired
	    private IRoleService iRoleService;

	    @RequestMapping(value = "/search")
	    public CrmResult<Role> getAllRole(
	            @ApiParam(value = "要查询的页码", required = true)
	            @RequestParam(defaultValue = "1")
	                    Integer page, //page请求的页码,默认为1
	            @ApiParam(value = "每页的行数", required = true)
	            @RequestParam(defaultValue = "8")
	                    Integer limit,//limit每页的行数，默认为10
	            Role role) {
	    	
	        QueryWrapper<Role> qw = new QueryWrapper<>();
	        
//	        if (user.getUserName() != null && user.getTel() != null) {
//	            qw.like("count_no", user.getCountNo());
//	            qw.or();
//	            qw.like("user_name", user.getUserName()); //第一个参数是字段名
//	            qw.or();
//	            qw.like("tel", user.getTel());
//	            qw.or();
//	            qw.like("work_status", user.getWorkStatus());
//	        }
	        
	        Page<Role> pageRole = iRoleService.page(
	                new Page<>(page, limit), qw);

	        CrmResult<Role> ret = new CrmResult<>();
	        ret.setCode(0);
	        ret.setMsg("");
	        ret.setCount(pageRole.getTotal());//表里的记录总数
	        ret.setData(pageRole.getRecords()); //这页的数据列表
	        return ret;
	    }

	    @ApiIgnore
	    @RequestMapping("/update")
	    public CrmResult<Role> updateRole(Role role) {
	        iRoleService.updateById(role);  //根据主键更新表

	        CrmResult<Role> ret = new CrmResult<>();
	        ret.setCode(0);
	        ret.setMsg("更新角色信息成功");
	        return ret;
	    }
	    
	    @ApiIgnore
	    @RequestMapping("/add")
	    public CrmResult<Role> addRole(Role role) {
//	    	保存时间，设置时区
	    	TimeZone time = TimeZone.getTimeZone("ETC/GMT-8");
	    	TimeZone.setDefault(time);
	    	role.setCreateTime(new Date());
	    	
	    	iRoleService.save(role);

	        CrmResult<Role> ret = new CrmResult<>();
	        ret.setCode(0);
	        ret.setMsg("新增角色成功");
	        return ret;
	    }

	    @ApiIgnore
	    @RequestMapping("/del")
	    public CrmResult<Role> delRole(String[] ids) {
	        iRoleService.removeByIds(Arrays.asList(ids));

	        CrmResult<Role> ret = new CrmResult<>();
	        ret.setCode(0);
	        ret.setMsg("删除成功");
	        return ret;
	    }
	    
//	    @ApiIgnore
//	    @RequestMapping("/selectById")
//	    public CrmResult<User> delUser(Integer id) {
//	       User user = iUserService.getById(id);
//	       List<User> list = new ArrayList<>();
//	       list.add(user);
//	        CrmResult<User> ret = new CrmResult<>();
//	        ret.setCode(0);
//	        ret.setMsg("");
//	        ret.setData(list);
//	        return ret;
//	    }
}

