package cn.edu.cqut.mapper;

import cn.edu.cqut.entity.Cusflew;
import cn.edu.cqut.entity.Record;
import cn.edu.cqut.entity.Customer;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author CQUT SE 2020
 * @since 2020-06-11
 */
public interface CusflewMapper extends BaseMapper<Cusflew> {
	/*
	 * @Select("select * from Cusflew ${ew.customSqlSegment}")//
	 * ${ew.customSqlSegment,sql语句的条件字段
	 * 
	 * @Results({
	 * 
	 * @Result(column = "cusNo", property = "cusNo"),
	 * 
	 * @Result(column = "cusNo", property = "cusNo", many = @Many( select =
	 * "cn.edu.cqut.mapper.CustomerMapper.selectOrderCustomerNoUpSixMonths",
	 * fetchType = FetchType.EAGER)) }) public Page<Record>
	 * selectRecordswithCusName( Page<Record> page,
	 * 
	 * @Param(Constants.WRAPPER) QueryWrapper<Record> queryWrapper );
	 */
  
	@Select("select * from customer where cusNo in (select orderCustomerNo from sales group by orderCustomerNo HAVING datediff(CURRENT_TIMESTAMP,max(orderTime))>180)")
	public List<Customer> selectOrCustomersOverSixMonths();
	
	@Select("select * from cusflew where cusNo=#{cusNo}")
	public List<Cusflew> isExitCusNo(String cusNo);
}
