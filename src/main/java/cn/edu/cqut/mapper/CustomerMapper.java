package cn.edu.cqut.mapper;

import cn.edu.cqut.entity.Customer;

import java.util.List;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

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

	@Select("select * from customer")
	@Results(id="Customer", value={
			@Result(column="cusNo", property="cusNo", id=true),
			@Result(column="cusName", property="cusName"),
			@Result(column="cusRegion ", property="cusRegion"),
			@Result(column="cusAddr", property="cusAddr"),
			@Result(column="cusUrl", property="cusUrl"),
			@Result(column="cusLevel", property="cusLevel"),
			@Result(column="cusCredit", property="cusCredit"),
			@Result(column="cusSatisfied", property="cusSatisfied")
	})
	public List<Customer> selectAllCustomer();
}
