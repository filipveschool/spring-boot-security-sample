package com.filip.springbootsecuritysample.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home.html");
        registry.addViewController("/").setViewName("home.html");
        registry.addViewController("/admin/home").setViewName("home.html");
        registry.addViewController("/login").setViewName("login.html");
        registry.addViewController("/logout").setViewName("login.html");
    }
}
