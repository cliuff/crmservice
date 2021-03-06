package cn.edu.cqut.service.impl;

import cn.edu.cqut.entity.Menu;
import cn.edu.cqut.mapper.MenuMapper;
import cn.edu.cqut.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author CQUT SE 2020
 * @since 2020-06-10
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

	@Override
	public List<Menu> selectFirstMenu(Integer parentId) {
//		自定义方法，返回一级菜单
		return baseMapper.selectFirstMenu(parentId);
	}

}
