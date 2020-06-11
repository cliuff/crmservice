package cn.edu.cqut.service;

import cn.edu.cqut.entity.Customer;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author HQYJ
 * @since 2020-06-03
 */
public interface ICustomerService extends IService<Customer> {

	public List<Customer> getCustomerWithContact();

	public List<Customer> getAllCustomer();

	public Page<Customer> getTotalTransactionAmount(Page<Customer> page, QueryWrapper<Customer> queryWrapper);

}
