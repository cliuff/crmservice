package cn.edu.cqut.service.impl;

import cn.edu.cqut.entity.Customer;
import cn.edu.cqut.stats.SimpleCategory;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.edu.cqut.entity.CustomerService;
import cn.edu.cqut.mapper.ServiceMapper;
import cn.edu.cqut.service.ServiceService;

import java.util.List;

@Service
public class ServiceServiceImpl extends ServiceImpl<ServiceMapper, CustomerService> implements ServiceService{

    @Override
    public List<SimpleCategory> getServiceComposition(QueryWrapper<Customer> queryWrapper) {
        return baseMapper.selectServiceComposition(queryWrapper);
    }
}
