package cn.edu.cqut.service;

import cn.edu.cqut.entity.Customer;
import cn.edu.cqut.stats.SimpleCategory;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.service.IService;

import cn.edu.cqut.entity.CustomerService;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ServiceService extends IService<CustomerService>{

    public List<SimpleCategory> getServiceComposition(
            @Param(Constants.WRAPPER) QueryWrapper<Customer> queryWrapper);
}
