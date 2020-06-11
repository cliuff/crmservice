package cn.edu.cqut.mapper;

import cn.edu.cqut.entity.Sales;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author CQUT SE 2020
 * @since 2020-06-10
 */
public interface SalesMapper extends BaseMapper<Sales> {

    @Select("select SUM(orderAmount) transactionAmount from sales where orderCustomerNo=#{customerNo}")
    public Double selectCustomersTotalAmount(String customerNo);
    
    
    

}
