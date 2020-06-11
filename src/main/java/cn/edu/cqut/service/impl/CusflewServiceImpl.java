package cn.edu.cqut.service.impl;

import cn.edu.cqut.entity.Cusflew;
import cn.edu.cqut.entity.Customer;
import cn.edu.cqut.mapper.CusflewMapper;
import cn.edu.cqut.service.ICusflewService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author CQUT SE 2020
 * @since 2020-06-11
 */
@Service
public class CusflewServiceImpl extends ServiceImpl<CusflewMapper, Cusflew> implements ICusflewService {

	@Override
	public List<Customer> getOrCustomersOverSixMonths() {
		// TODO Auto-generated method stub
		return baseMapper.selectOrCustomersOverSixMonths();
	}

	@Override
	public boolean isExitCusNo(String cusNo) {
		// TODO Auto-generated method stub
		
		if(!baseMapper.isExitCusNo(cusNo).isEmpty())
		{
			return true;
		}
		else
		return false;
	}

	

}
