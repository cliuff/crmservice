package cn.edu.cqut.mapper;

import cn.edu.cqut.entity.UserRole;

import org.apache.ibatis.annotations.Insert;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author CQUT SE 2020
 * @since 2020-06-10
 */
public interface UserRoleMapper extends BaseMapper<UserRole> {
	@Insert("INSERT into user_role(user_id) VALUES (#{userId})")
	public Integer addUserRoleById(Integer userId);
}
