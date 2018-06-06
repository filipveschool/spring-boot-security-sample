package com.filip.springbootsecuritysample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                // Generate API of EndPoints which is available inside defined package
                .apis(RequestHandlerSelectors.basePackage("com.filip.reservationapi.controllers"))
                // for all EndPoints
                .paths(PathSelectors.any())
                // create object
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("Filip VE NAME", "URL", "email");
        return new ApiInfoBuilder()
                .title("Filip's REST API")
                .description("Example of an API for my blogpost")
                .version("1.0")
                .termsOfServiceUrl("Terms of Service URL")
                .contact(contact)
                .license("License of API")
                .licenseUrl("API License URL")
                .build();
    }
}
