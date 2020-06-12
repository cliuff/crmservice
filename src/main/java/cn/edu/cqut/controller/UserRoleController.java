package cn.edu.cqut.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.cqut.entity.Role;
import cn.edu.cqut.entity.UserRole;
import cn.edu.cqut.service.IUserRoleService;
import cn.edu.cqut.util.CrmResult;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Date;
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
@RequestMapping("/userRole")
public class UserRoleController {
	@Autowired
	private IUserRoleService iUserRoleService;
	   @ApiIgnore
	    @RequestMapping("/addUserRoleById")
	   public Integer addUserRoleById(Integer userId) {
			iUserRoleService.addUserRoleById(userId);
			return null;
		}

}

