package org.easy.mallpositioning.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/api")
@Api("GPS定位")
public class GpsDataController {
    @PostMapping("/location")
    @ApiOperation("定位数据")
    public String location(@RequestBody String data) {
        System.out.println("========="+data);
        return data;
    }





}
