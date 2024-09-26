package org.easy.mallpositioning.controller;

import org.easy.mallpositioning.service.ILocationDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author meng
 * @since 2024-09-26
 */
@RestController
@RequestMapping("/mallpositioning/locationData")
public class LocationDataController {
    @Autowired
    private ILocationDataService locationDataService;

    @GetMapping("gs")
    public String gps() {
        return "gps";
    }
}
