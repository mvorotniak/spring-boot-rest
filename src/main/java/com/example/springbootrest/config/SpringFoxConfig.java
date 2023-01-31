package com.example.springbootrest.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.StringVendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.example.springbootrest.controller"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        return new ApiInfo(
            "Spring Boot Rest API",
            "API Documentation",
            "1.0.0",
            "",
            new Contact("Mariana", "/my/url", "email@gmail.com"),
            null, null, Collections.singleton(new StringVendorExtension("Vendor", ""))
        );
    }

    // Added because of "Swagger error Springboot Could not resolve view with name 'forward:/swagger-ui/index.html'"
    @Bean
    public InternalResourceViewResolver defaultViewResolver() {
        return new InternalResourceViewResolver();
    }

}
