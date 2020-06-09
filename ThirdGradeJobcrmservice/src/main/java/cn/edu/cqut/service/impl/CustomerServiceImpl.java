package cn.edu.cqut.service.impl;

import cn.edu.cqut.entity.Customer;
import cn.edu.cqut.mapper.CustomerMapper;
import cn.edu.cqut.service.ICustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author CQUT SE 2020
 * @since 2020-06-08
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {

}
