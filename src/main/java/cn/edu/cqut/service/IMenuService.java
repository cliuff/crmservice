package cn.edu.cqut.service;

import cn.edu.cqut.entity.Menu;

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
public interface IMenuService extends IService<Menu> {
	public List<Menu> selectFirstMenu(Integer parentId);
}
