package cn.edu.cqut.service;

import cn.edu.cqut.entity.Cusflew;
import cn.edu.cqut.entity.Customer;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CQUT SE 2020
 * @since 2020-06-11
 */
public interface ICusflewService extends IService<Cusflew> {
	public List<Customer> getOrCustomersOverSixMonths();
	public boolean isExitCusNo(String cusNo);

	public Page<Customer> getLost(
			Page<Customer> page,
			@Param(Constants.WRAPPER) QueryWrapper<Customer> queryWrapper
	);
}
