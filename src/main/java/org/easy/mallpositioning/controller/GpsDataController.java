package org.easy.mallpositioning.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.easy.mallpositioning.entity.GpsData;
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
 * @since 2024-09-21
 */
@CrossOrigin
@RestController
@RequestMapping("/api")
@Api("GPS定位")
public class GpsDataController {

    @Autowired
    private GpsWebSocketHandler gpsWebSocketHandler;

    @PostMapping("/location")
    @ApiOperation("定位数据")
    public String location(@RequestBody GpsData gpsData) {
        // 打印接收到的GPS数据
        System.out.println("接收到的GPS数据: " + gpsData.getLatitude() + ", " + gpsData.getLongitude());

        // 根据监控端ID，将GPS数据推送到指定监控端
        gpsWebSocketHandler.sendGpsDataToMonitor(gpsData.getMonitorId(), gpsData.toJsonString());

        return "GPS数据已接收并推送给监控端";
    }





}
