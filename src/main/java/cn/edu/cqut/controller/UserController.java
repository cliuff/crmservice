package cn.edu.cqut.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.edu.cqut.entity.Customer;
import cn.edu.cqut.entity.User;
import cn.edu.cqut.service.ICustomerService;
import cn.edu.cqut.service.IUserService;
import cn.edu.cqut.util.CrmResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
@CrossOrigin
@RequestMapping("/user")
public class UserController {
	 @Autowired
	    private IUserService iUserService;

	    @RequestMapping(value = "/search")
	    public CrmResult<User> getAllUser(
	            @ApiParam(value = "要查询的页码", required = true)
	            @RequestParam(defaultValue = "1")
	                    Integer page, //page请求的页码,默认为1
	            @ApiParam(value = "每页的行数", required = true)
	            @RequestParam(defaultValue = "8")
	                    Integer limit,//limit每页的行数，默认为10
	            User user) {
	        QueryWrapper<User> qw = new QueryWrapper<>();
	        
//	        SELECT id,count_no,user_name,pwd,tel,work_status FROM user WHERE (user_name LIKE ? OR tel LIKE ?) LIMIT ?,?
	        
	        if (user.getUserName() != null && user.getTel() != null) {
	            qw.like("count_no", user.getCountNo());
	            qw.or();
	            qw.like("user_name", user.getUserName()); //第一个参数是字段名
	            qw.or();
	            qw.like("tel", user.getTel());
	            qw.or();
	            qw.like("work_status", user.getWorkStatus());
	        }
	        Page<User> pageUser = iUserService.page(
	                new Page<>(page, limit), qw);

	        CrmResult<User> ret = new CrmResult<>();
	        ret.setCode(0);
	        ret.setMsg("");
	        ret.setCount(pageUser.getTotal());//表里的记录总数
	        ret.setData(pageUser.getRecords()); //这页的数据列表
	        return ret;
	    }

	    @ApiIgnore
	    @RequestMapping("/update")
	    public CrmResult<User> updateUser(User user) {
	        iUserService.updateById(user);  //根据主键更新表

	        CrmResult<User> ret = new CrmResult<>();
	        ret.setCode(0);
	        ret.setMsg("更新用户信息成功");
	        return ret;
	    }

	    @ApiIgnore
	    @RequestMapping("/add")
	    public CrmResult<User> addUser(User user) {
	    	iUserService.save(user);

	        CrmResult<User> ret = new CrmResult<>();
	        ret.setCode(0);
	        ret.setMsg("新增用户成功");
	        return ret;
	    }

	    @ApiIgnore
	    @RequestMapping("/del")
	    public CrmResult<User> delUser(String[] ids) {
	        iUserService.removeByIds(Arrays.asList(ids));

	        CrmResult<User> ret = new CrmResult<>();
	        ret.setCode(0);
	        ret.setMsg("删除成功");
	        return ret;
	    }
	    
	    @ApiIgnore
	    @RequestMapping("/selectById")
	    public CrmResult<User> delUser(Integer id) {
	       User user = iUserService.getById(id);
	       List<User> list = new ArrayList<>();
	       list.add(user);
	        CrmResult<User> ret = new CrmResult<>();
	        ret.setCode(0);
	        ret.setMsg("");
	        ret.setData(list);
	        return ret;
	    }
	    
	    @ApiIgnore
	    @RequestMapping("/updateRoleByUserId")
	    public void updateRoleByUserId(Integer roleId, Integer userId) {
	    	iUserService.updateRoleByUserId(roleId, userId);	       
		}
}

