package org.easy.mallpositioning.service.impl;

import org.easy.mallpositioning.entity.Users;
import org.easy.mallpositioning.mapper.UsersMapper;
import org.easy.mallpositioning.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author meng
 * @since 2024-09-26
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {
    @Override
    public List<Users> getAllUsers() {
        return baseMapper.selectList(null);
    }

}
