package cn.edu.cqut.mapper;

import cn.edu.cqut.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author CQUT SE 2020
 * @since 2020-06-09
 */
public interface UserMapper extends BaseMapper<User> {

    @Select("SELECT `user`.id,user_name,`user`.count_no,`user`.pwd,`user`.tel,`user`.work_status\n" +
            "FROM `user`,user_role\n" +
            "WHERE `user`.id = user_role.user_id and user_role.role_id = 3 and `user`.work_status = '任职'")
    @Results(id="User", value={
            @Result(column="id", property="id", id=true),
            @Result(column="countNo", property="count_no"),
            @Result(column="userName ", property="user_name"),
            @Result(column="pwd", property="pwd"),
            @Result(column="tel", property="tel"),
            @Result(column="workStatus", property="work_status")

    })
    List<User> getUserByRole();

}
