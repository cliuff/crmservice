package cn.edu.cqut.service.impl;

import cn.edu.cqut.entity.Customer;
import cn.edu.cqut.mapper.CustomerMapper;
import cn.edu.cqut.service.ICustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

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


}
