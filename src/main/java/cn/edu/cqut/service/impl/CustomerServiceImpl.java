package cn.edu.cqut.service.impl;

import cn.edu.cqut.entity.Customer;
import cn.edu.cqut.mapper.CustomerMapper;
import cn.edu.cqut.service.ICustomerService;
import cn.edu.cqut.stats.SimpleCategory;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author HQYJ
 * @since 2020-06-03
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {
	@Override
	public List<Customer> getCustomerWithContact() {
		return baseMapper.selectCustomerWithContact();
	}//实现Mapper层的对应方法

	@Override
	public Page<Customer> getTotalTransactionAmount(Page<Customer> page, QueryWrapper<Customer> queryWrapper) {
		return baseMapper.selectTotalTransactionAmount(page, queryWrapper);
	}
	@Override
	public List<Customer> getAllCustomer() {
		return baseMapper.selectAllCustomer();
	}


	@Override
	public List<SimpleCategory> getCustomerComposition(QueryWrapper<Customer> queryWrapper) {
		return baseMapper.selectCustomerComposition(queryWrapper);
	}

}
