package org.easy.mallpositioning.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Param;
import org.easy.mallpositioning.Vo.UserVo;
import org.easy.mallpositioning.entity.MonitorTrackedMapping;
import org.easy.mallpositioning.entity.Users;
import org.easy.mallpositioning.result.Result;
import org.easy.mallpositioning.service.IMonitorTrackedMappingService;
import org.easy.mallpositioning.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author meng
 * @since 2024-09-26
 */
@CrossOrigin
@RestController
@RequestMapping("/mallpositioning/users")
@Api(value = "用户管理",tags = "用户管理")
public class UsersController {
    @Autowired
    private IUsersService usersService;
    @Autowired
    IMonitorTrackedMappingService mappingService;

    @GetMapping("list")
    @ApiOperation("获取所有用户信息")
    public Result list() {
        return Result.ok(usersService.getAllUsers());
    }

    @GetMapping("login/{username}/{password}")
    @ApiOperation("用户登录")
    public Result login(@ApiParam(name = "username",value ="用户名")@PathVariable String username,
                        @ApiParam(name = "password",value = "密码")@PathVariable String password) throws JsonProcessingException {
        UserVo data=usersService.userLoginData(username, password);
        System.out.println(data);
        if(data!=null){
            return Result.ok(data);
        }else {
            return Result.fail(null);
        }

    }
    @GetMapping("bind/{userId}/{deviceId}")
    @ApiOperation("绑定设备")
    public Result bind(@ApiParam(name = "userId",value = "用户id")@PathVariable Long userId,
            @ApiParam(name = "deviceId",value = "设备id")@PathVariable Long deviceId){
        MonitorTrackedMapping mapping=new MonitorTrackedMapping();
        mapping.setMonitorId(userId);
        mapping.setTrackedDeviceId(deviceId);
        return Result.ok(mappingService.save(mapping));

    }

}
