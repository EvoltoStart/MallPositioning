package org.easy.mallpositioning.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.easy.mallpositioning.entity.Users;
import org.easy.mallpositioning.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

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
@Api("用户接口")
public class UsersController {
    @Autowired
    private IUsersService usersService;

    @GetMapping("list")
    @ApiOperation("获取所有用户信息")
    public List<Users> list() {
        return usersService.getAllUsers();
    }

}
