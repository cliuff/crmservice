package cn.edu.cqut.mapper;

import cn.edu.cqut.entity.Customer;
import cn.edu.cqut.stats.SimpleCategory;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.edu.cqut.entity.CustomerService;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ServiceMapper extends BaseMapper<CustomerService>{

    @Select("select ${ew.sqlSelect} FROM customer_service ${ew.customSqlSegment}")
    public List<SimpleCategory> selectServiceComposition(
            @Param(Constants.WRAPPER) QueryWrapper<Customer> queryWrapper);
}
