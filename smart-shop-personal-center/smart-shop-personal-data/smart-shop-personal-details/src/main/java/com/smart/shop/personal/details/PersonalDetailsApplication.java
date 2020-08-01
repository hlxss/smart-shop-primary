package com.smart.shop.personal.details;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Administrator
 */
@SpringBootApplication
@MapperScan("com.smart.shop.personal.details.mapper")
public class PersonalDetailsApplication {
    public static void main(String[] args) {
        SpringApplication.run(PersonalDetailsApplication.class, args);
    }
}
