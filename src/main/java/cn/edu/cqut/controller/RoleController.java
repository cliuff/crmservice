package cn.edu.cqut.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.edu.cqut.entity.Menu;
import cn.edu.cqut.entity.Role;
import cn.edu.cqut.entity.User;
import cn.edu.cqut.service.IMenuService;
import cn.edu.cqut.service.IRoleService;
import cn.edu.cqut.service.IUserRoleService;
import cn.edu.cqut.service.IUserService;
import cn.edu.cqut.util.CrmResult;
import cn.edu.cqut.util.MenuStage;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
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
	 	@Autowired
	 	private IUserRoleService iUserRoleService;
	 	@Autowired
	    private IMenuService iMenuService;
	 	
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
	        
	        if (role.getRoleName() != null) {
	            qw.like("role_name", role.getRoleName());
	        }
	        
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
	    	iUserRoleService.addUserRoleById(role.getId());
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
	    
	    @ApiIgnore
	    @RequestMapping(value="/selectMenuNameById",method = RequestMethod.GET)
	    public List<MenuStage> selectMenuNameById(Integer id){
//	    	结果
	    	List<MenuStage> menuStages = new ArrayList<>();
	    	List<String> menu = new ArrayList<>();
//	    	一级菜单
	    	List<Menu> list= iMenuService.selectFirstMenu(id);
	    	List<HashMap<String, String>> menus= new ArrayList<>();
	    	
	    	
	    	for (int i = 0; i < list.size(); i++) {
	    		MenuStage menuStage = new MenuStage();
	    		HashMap<String, String> map = new HashMap<>();
	    		
	    		menuStage.setTitle(list.get(i).getName());
	    		
	    		menu = iRoleService.selectMenuNameById(list.get(i).getId());
	    		
	    		//	    	设置子级菜单
	    		for (int j = 0; j < menu.size(); j++) {
					map.put("title",menu.get(j));
				}
	    		menus.add(map);
				menuStage.setChildren(menus);
//				添加
				menuStages.add(menuStage);								
			}
	    	return menuStages;
	    }
}

