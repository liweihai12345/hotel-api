package com.platform.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Profile("dev")
@Configuration
@EnableSwagger2
@ComponentScan(basePackages = "com.platform.api")
public class SwaggerConfig {

    @Bean
    public Docket api() {

        ParameterBuilder accessToken = new ParameterBuilder();
        ParameterBuilder timestamp = new ParameterBuilder();
        ParameterBuilder uid = new ParameterBuilder();
        ParameterBuilder token = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        accessToken.name("access_token").description("临时令牌").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        timestamp.name("uid").description("编号").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        uid.name("timestamp").description("时间毫秒").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        token.name("token").description("令牌").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(accessToken.build());
        pars.add(timestamp.build());
        pars.add(uid.build());
        pars.add(token.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(this.apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.platform.api"))
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.any())
                .build().globalOperationParameters(pars);
    }


    private ApiInfo apiInfo() {
        @SuppressWarnings("deprecation")
        ApiInfo info = new ApiInfo(
                "APP接口文档",
                "APP接口文档",
                "1.0",
                "urn:tos",
                "platform",
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0");
        return info;
    }


}