package com.smart.shop.personal.pay;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Administrator
 */

@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
@MapperScan("com.smart.shop.personal.pay.mapper")
@EnableSwagger2
public class PersonalPayApplication {
    public static void main(String[] args) {
        SpringApplication.run(PersonalPayApplication.class, args);
    }
}
