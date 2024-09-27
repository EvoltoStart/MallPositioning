package org.easy.mallpositioning.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.easy.mallpositioning.entity.LocationData;
import org.easy.mallpositioning.entity.PathData;
import org.easy.mallpositioning.result.Result;
import org.easy.mallpositioning.service.ILocationDataService;
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
@RequestMapping("/api")
@Api(value = "位置数据接口", tags = "位置数据接口")
public class LocationDataController {
    @Autowired
    private ILocationDataService locationDataService;

    @Autowired
    private IPathDataService pathDataService;

    @Autowired
    private GpsWebSocketHandler gpsWebSocketHandler;


    @PostMapping("/location")
    @ApiOperation("gps位置数据接口")
    public Result receiveLocation(@RequestBody LocationData locationData) throws JsonProcessingException {
        // 保存到数据库
        //locationDataService.saveLocationData(locationData);
        PathData path = pathDataService.getPathData(locationData.getUserid());
        String paths = path.getPath();
        // 创建 ObjectMapper 实例
        ObjectMapper objectMapper = new ObjectMapper();

        // 解析 JSON 数组字符串
        JsonNode jsonNode = objectMapper.readTree(paths);
        if (jsonNode.isArray()) {
            // 获取数组
            ArrayNode arrayNode = (ArrayNode) jsonNode;

            // 创建一个新的 JSON 对象
            ObjectNode newObjectNode = objectMapper.createObjectNode();
            newObjectNode.put("latitude", locationData.getLatitude()); // 新的纬度
            newObjectNode.put("longitude", locationData.getLongitude()); // 新的经度
            newObjectNode.put("timestamp", String.valueOf(locationData.getTimestamp())); // 新的时间戳

            // 追加新对象到数组
            arrayNode.add(newObjectNode);

            // 将更新后的 JSON 数组转换回字符串
            paths = arrayNode.toString();
            System.out.println(paths);
            path.setPath(paths);
            pathDataService.updateById(path);// 更新数据库中的路径数据


            // 找到指定监控端并发送数据

            System.out.println(locationData);
            gpsWebSocketHandler.sendMessageToClient(locationData.getDeviceId(), locationData.toString());

        }

        return Result.ok();
    }
}
