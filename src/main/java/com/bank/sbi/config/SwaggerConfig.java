package com.bank.sbi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static io.swagger.v3.core.util.AnnotationsUtils.getInfo;

@Configuration
public class SwaggerConfig {
    @Bean
    OpenAPI openAPI() {// Here we create an object of openApi class.
       /* var info=new Info();
        info.setTitle("Student Management System");
        info.setDescription("Manage Student Recodrd");
        info.setVersion("v2");*/
        return new OpenAPI().info(getInfo());
    }
    private Info getInfo(){
        var info=new Info();
        info.setTitle("Banking System");
        info.setDescription("Manage money");
        info.setVersion("v1");
        return info;
    }
}
