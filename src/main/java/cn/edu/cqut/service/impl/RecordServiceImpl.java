package cn.edu.cqut.service.impl;

import cn.edu.cqut.entity.Record;
import cn.edu.cqut.mapper.RecordMapper;
import cn.edu.cqut.service.IRecordService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record> implements IRecordService {

	@Override
	public Page<Record> selectRecordswithCusName(Page<Record> page, QueryWrapper<Record> queryWrapper) {
		// TODO Auto-generated method stub
	return	baseMapper.selectRecordswithCusName(page, queryWrapper);
		
	}

	


}
