package com.smart.shop.personal.pay.conf;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author Administrator
 */
@Configuration

public class SwaggerConf {

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("smart-shop-personal-details接口文档")
                .description("此接口文档包含了商城项目个人信息模块的所有接口文档").build();
    }

    public Docket docket(ApiInfo apiInfo) {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo);
    }
}
