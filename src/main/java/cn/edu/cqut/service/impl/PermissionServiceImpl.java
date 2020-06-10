package cn.edu.cqut.service.impl;

import cn.edu.cqut.entity.Permission;
import cn.edu.cqut.mapper.PermissionMapper;
import cn.edu.cqut.service.IPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author CQUT SE 2020
 * @since 2020-06-10
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

}
