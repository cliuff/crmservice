package cn.edu.cqut.mapper;

import cn.edu.cqut.entity.Customer;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author HQYJ
 * @since 2020-06-03
 */
public interface CustomerMapper extends BaseMapper<Customer> {
	//没懂,通过contact的cusNo对customer中的数据进行查询
	//many,一对多
	@Select("select * from customer")
	@Results({
		@Result(column="cusNo",property="cusNo"),//显示cusNo
		@Result(column="cusNo",property="contacts",many= @Many(
				select="cn.edu.cqut.mapper.ContactMapper.selectContactByCusNo",
				fetchType=FetchType.EAGER))//通过cusNo显示联系人列表
		
	})
	public List<Customer> selectCustomerWithContact();

	@Select("select cusNo, cusName from customer ${ew.customSqlSegment}")
	@Results({
			@Result(column = "cusNo", property = "cusNo"),
			@Result(column = "cusNo", property = "transactionAmount", one = @One(
					select = "cn.edu.cqut.mapper.SalesMapper.selectCustomersTotalAmount",
					fetchType = FetchType.EAGER)
			)
	})
	public Page<Customer> selectTotalTransactionAmount(
			Page<Customer> page,
			@Param(Constants.WRAPPER) QueryWrapper<Customer> queryWrapper
	);
	
@Select("select cusName from customer where cusNo=#{cusNo}")
public String selectCusNameByCusNo(String cusNo);
}
