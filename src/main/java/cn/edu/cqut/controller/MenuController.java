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
import cn.edu.cqut.service.IMenuService;
import cn.edu.cqut.service.IRoleService;
import cn.edu.cqut.util.CrmResult;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

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
@RequestMapping("/menu")
public class MenuController {
	 @Autowired
	    private IMenuService iMenuService;

	    @RequestMapping(value = "/search")
	    public CrmResult<Menu> getAllMenu(
	            @ApiParam(value = "要查询的页码", required = true)
	            @RequestParam(defaultValue = "1")
	                    Integer page, //page请求的页码,默认为1
	            @ApiParam(value = "每页的行数", required = true)
	            @RequestParam(defaultValue = "8")
	                    Integer limit,//limit每页的行数，默认为10
	            Menu menu) {
	    	
	        QueryWrapper<Menu> qw = new QueryWrapper<>();
	        
	        if (menu.getName() != null && menu.getStage() != null) {
	            qw.like("name", menu.getName());
	            qw.or();
	            qw.like("stage", menu.getStage()); //第一个参数是字段名
	        }
	        
	        Page<Menu> pageMenu = iMenuService.page(
	                new Page<>(page, limit), qw);

	        CrmResult<Menu> ret = new CrmResult<>();
	        ret.setCode(0);
	        ret.setMsg("");
	        ret.setCount(pageMenu.getTotal());//表里的记录总数
	        ret.setData(pageMenu.getRecords()); //这页的数据列表
	        return ret;
	    }
	    
//	    自定义方法
	    @ApiIgnore
	    @RequestMapping(value="/selectParent",method = RequestMethod.GET)
	    public CrmResult<Menu> selectFirstMenu(Integer parentId){
	    	 CrmResult<Menu> ret = new CrmResult<>();
		        ret.setCode(0);
		        ret.setMsg("");
//		        ret.setCount(pageMenu.getTotal());//表里的记录总数
		        ret.setData(iMenuService.selectFirstMenu(parentId)); //这页的数据列表
	    	return ret;
	    }
	    
	    
	    @ApiIgnore
	    @RequestMapping("/update")
	    public CrmResult<Menu> updateMenu(Menu menu) {
	        iMenuService.updateById(menu);  //根据主键更新表

	        CrmResult<Menu> ret = new CrmResult<>();
	        ret.setCode(0);
	        ret.setMsg("更新菜单成功");
	        return ret;
	    }
	    
	    @ApiIgnore
	    @RequestMapping("/add")
	    public CrmResult<Menu> addMenu(Menu menu) {
	    	
	    	iMenuService.save(menu);

	        CrmResult<Menu> ret = new CrmResult<>();
	        ret.setCode(0);
	        ret.setMsg("新增菜单成功");
	        return ret;
	    }

	    @ApiIgnore
	    @RequestMapping("/del")
	    public CrmResult<Menu> delMenu(String[] ids) {
	        iMenuService.removeByIds(Arrays.asList(ids));

	        CrmResult<Menu> ret = new CrmResult<>();
	        ret.setCode(0);
	        ret.setMsg("删除成功");
	        return ret;
	    }
}

