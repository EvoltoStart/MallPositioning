package org.easy.mallpositioning.CodeGet;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.sql.Types;
import java.util.Collections;

public class CodeGet {

    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/mallpositioning_1", "root", "root")
                .globalConfig(builder -> {
                    builder.author("meng") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .outputDir("D:\\Program development\\Project\\MallPositioning"+"/src/main/java"); // 指定输出目录
                })
                .dataSourceConfig(builder ->
                        builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                            int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                            if (typeCode == Types.SMALLINT) {
                                // 自定义类型转换
                                return DbColumnType.INTEGER;
                            }
                            return typeRegistry.getColumnType(metaInfo);
                        })
                )
                .packageConfig(builder ->
                        builder.parent("org.easy") // 设置父包名
                                .moduleName("mallpositioning") // 设置父包模块名
                                .pathInfo(Collections.singletonMap(OutputFile.xml, "D:\\Program development\\Project\\MallPositioning\\src\\main\\java\\com\\esay\\mallpositioning\\mapper\\xml")) // 设置mapperXml生成路径
                )
                .strategyConfig(builder ->
                        builder.addInclude("users","devices","location_data",
                                        "monitor_tracked_mapping",
                                        "path_data") // 设置需要生成的表名
                                .addTablePrefix("t_", "c_") // 设置过滤表前缀
                )
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

}

