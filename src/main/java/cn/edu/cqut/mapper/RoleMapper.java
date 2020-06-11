package cn.edu.cqut.mapper;

import cn.edu.cqut.entity.Role;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author CQUT SE 2020
 * @since 2020-06-10
 */
public interface RoleMapper extends BaseMapper<Role> {
	@Select("SELECT menu.name FROM menu WHERE  menu.parent=#{id}")
    public List<String> selectMenuNameById(Integer id);
	
//	@Select("SELECT menu.name FROM menu,role,role_menu WHERE role_menu.role_id = role.id AND role_menu.menu_id = menu.id AND role.parent=#{id}")
//    public List<String> selectMenuNameById(Integer id);
}
