package org.easy.mallpositioning.controller;

import org.easy.mallpositioning.entity.LocationData;
import org.easy.mallpositioning.service.ILocationDataService;
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
@RestController
@RequestMapping("/api")
public class LocationDataController {
    @Autowired
    private ILocationDataService locationDataService;
    @Autowired
    private GpsWebSocketHandler gpsWebSocketHandler;


    @PostMapping("/location")
    public String receiveLocation(@RequestBody LocationData locationData) {
        // 保存到数据库
        //locationDataService.saveLocationData(locationData);

        // 找到指定监控端并发送数据
        String message = "Device " + locationData.getDeviceId() +
                " is at [" + locationData.getLatitude() + ", " + locationData.getLongitude() + "]";
        gpsWebSocketHandler.sendMessageToClient(locationData.getDeviceId(), message);

        return "Location data received and sent to specific monitor.";
    }

}
