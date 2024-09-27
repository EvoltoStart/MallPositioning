package org.easy.mallpositioning.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.easy.mallpositioning.Vo.UserVo;
import org.easy.mallpositioning.entity.MonitorTrackedMapping;
import org.easy.mallpositioning.entity.Users;
import org.easy.mallpositioning.mapper.UsersMapper;
import org.easy.mallpositioning.service.ILocationDataService;
import org.easy.mallpositioning.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private ILocationDataService locationDataService;

    @Override
    public List<Users> getAllUsers() {

        return baseMapper.selectList(null);
    }


    @Override
    public UserVo userLoginData(String username, String password) throws JsonProcessingException {
        Users user=null;
        LambdaQueryWrapper<Users> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(Users::getUsername,username).eq(Users::getPassword,password);
        user=baseMapper.selectOne(wrapper);
        if(user!=null&&user.getRole().equals("TRACKED")){

            List<String> allDeviceId = locationDataService.getAllDeviceId(user.getId());
            UserVo userVo=new UserVo();
            userVo.setDeviceIds(allDeviceId);
            userVo.setId(user.getId());
            userVo.setPassword(user.getPassword());
            userVo.setUsername(user.getUsername());
            userVo.setRole(user.getRole());
            return userVo;


        }
        else if(user!=null&&user.getRole().equals("MONITOR")){
                return new UserVo(user.getId(),user.getUsername(),user.getPassword(),user.getRole());
            }
        else return null;

    }


}
