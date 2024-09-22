package org.easy.mallpositioning.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author meng
 * @since 2024-09-21
 */
@Controller
@RequestMapping("/api")
public class GpsDataController {
    @PostMapping("/location")
    public String location(@RequestBody String data) {
        System.out.println("========="+data);
        return "success";
    }





}
