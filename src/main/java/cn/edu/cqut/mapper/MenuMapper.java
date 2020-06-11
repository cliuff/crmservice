package cn.edu.cqut.mapper;

import cn.edu.cqut.entity.Contact;
import cn.edu.cqut.entity.Menu;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author CQUT SE 2020
 * @since 2020-06-10
 */
public interface MenuMapper extends BaseMapper<Menu> {
	@Select("select * from menu where parent = #{parentId}")
	public List<Menu> selectFirstMenu(Integer parentId);
}
