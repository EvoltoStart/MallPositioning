package org.easy.mallpositioning.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.easy.mallpositioning.entity.PathData;
import org.easy.mallpositioning.result.Result;
import org.easy.mallpositioning.service.IPathDataService;
import org.easy.mallpositioning.websocket.GpsWebSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

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
@RequestMapping("/mallpositioning/pathData")
@Api(value = "路径数据",tags = "路径数据")
public class PathDataController {
    /**
     * 路径数据
     */
    @Autowired
    private IPathDataService pathDataService;
    @Autowired
    private GpsWebSocketHandler gpsWebSocketHandler;

    @GetMapping("path/{userId}")
    @ApiOperation("返回路径数据")
    public Result path(@ApiParam(name = "userId", value = "用户id") @PathVariable Long userId){
        PathData pathData = pathDataService.getPathData(userId);
        gpsWebSocketHandler.sendMessageToClient(pathData.getDeviceId(), pathData.toString());
        System.out.println(pathData);
        if(pathData!=null){
            return Result.ok(pathData);
        }else return Result.fail(null);
    }

}
