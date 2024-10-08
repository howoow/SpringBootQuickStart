package com.example.oral.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean(name = "api1")
    Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.example.biology")).paths(PathSelectors.any()).build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("API测试文档").description("接口测试文档").version("1.0").build();
    }
}

