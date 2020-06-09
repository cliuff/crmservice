package cn.edu.cqut.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.edu.cqut.entity.CustomerService;
import cn.edu.cqut.mapper.ServiceMapper;
import cn.edu.cqut.service.ServiceService;

@Service
public class ServiceServiceImpl extends ServiceImpl<ServiceMapper, CustomerService> implements ServiceService{
	

}
