package cn.edu.cqut.service;

import cn.edu.cqut.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CQUT SE 2020
 * @since 2020-06-09
 */
public interface IUserService extends IService<User> {
    List<User> getUserByRole();
    
    public void updateRoleByUserId(Integer roleId,Integer userId);
}
