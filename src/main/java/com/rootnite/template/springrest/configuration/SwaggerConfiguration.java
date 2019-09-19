package com.rootnite.template.springrest.configuration;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * @author Edy Huiza
 * @version 1.0
 * Created on 19/09/2019
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket deviceAPI() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Rest API CRUD template with scalable structure")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.rootnite.template.springrest.controller"))
                .paths(postPaths())
                .build()
                .apiInfo(apiInfo());
    }

    private Predicate<String> postPaths() {
        return or(regex("/oauth/token.*"), regex("/api/v1.*"));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("CRUD tempalte - API REST v1")
                .description("REST API - CRUD template with scalable structure")
                .version("1.0")
                .contact(new Contact("Edy Huiza Yampasi", "http://www.rootnite.com", "edy.huiza@rootnite.com"))
                .build();
    }
}
