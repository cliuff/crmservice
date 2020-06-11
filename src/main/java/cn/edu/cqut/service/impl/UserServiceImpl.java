package cn.edu.cqut.service.impl;

import cn.edu.cqut.entity.User;
import cn.edu.cqut.mapper.UserMapper;
import cn.edu.cqut.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author CQUT SE 2020
 * @since 2020-06-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public List<User> getUserByRole() {
        return baseMapper.getUserByRole();
    }
}
