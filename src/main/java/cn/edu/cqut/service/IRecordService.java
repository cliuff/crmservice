package cn.edu.cqut.service;

import cn.edu.cqut.entity.Record;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CQUT SE 2020
 * @since 2020-06-10
 */
public interface IRecordService extends IService<Record> {
	public Page<Record> selectRecordswithCusName(
			Page<Record> page,
			@Param(Constants.WRAPPER) QueryWrapper<Record> queryWrapper
	);


}
