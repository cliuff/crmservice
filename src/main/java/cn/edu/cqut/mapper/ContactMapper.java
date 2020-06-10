package cn.edu.cqut.mapper;

import cn.edu.cqut.entity.Contact;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author CQUT SE 2020
 * @since 2020-06-08
 */
public interface ContactMapper extends BaseMapper<Contact> {
	@Select("select * from contact where cusNo=#{cusNo}")
	public List<Contact> selectContactByCusNo(String cusNo);
}
