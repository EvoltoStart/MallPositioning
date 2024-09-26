package org.easy.mallpositioning.service;

import org.easy.mallpositioning.entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author meng
 * @since 2024-09-26
 */
public interface IUsersService extends IService<Users> {

    public List<Users> getAllUsers();
}
