package cn.edu.cqut.service;

import cn.edu.cqut.entity.Role;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CQUT SE 2020
 * @since 2020-06-10
 */
public interface IRoleService extends IService<Role> {
	 public List<String> selectMenuNameById(Integer id);
}
