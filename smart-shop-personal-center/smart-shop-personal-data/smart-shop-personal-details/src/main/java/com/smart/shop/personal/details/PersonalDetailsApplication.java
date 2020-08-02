package com.smart.shop.personal.details;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Administrator
 */
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
@EnableSwagger2
@MapperScan("com.smart.shop.personal.details.mapper")
public class PersonalDetailsApplication {
    public static void main(String[] args) {
        SpringApplication.run(PersonalDetailsApplication.class, args);
    }
}
