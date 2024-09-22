package org.easy.mallpositioning.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.easy.mallpositioning.entity.Users;
import org.easy.mallpositioning.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author meng
 * @since 2024-09-21
 */
@CrossOrigin
@RestController
@Api("用户")
@RequestMapping("/mallpositioning/users")
public class UsersController {

    @Autowired
    private IUsersService usersService;
    @ApiOperation("xxx")
    @GetMapping("/index")
    public Users index(){
      Users users= usersService.getById(1);
      return users;

    }
}
