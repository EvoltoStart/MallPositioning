package org.easy.mallpositioning;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.easy.mallpositioning.mapper")
public class MallPositioningApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallPositioningApplication.class, args);
    }

}
