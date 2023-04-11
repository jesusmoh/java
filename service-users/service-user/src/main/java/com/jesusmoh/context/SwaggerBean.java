package com.jesusmoh.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerBean {

	 @Bean
	    public OpenAPI customOpenAPI() {
	        return new OpenAPI()
	                .info(new Info()
	                        .title("Urp Users")
	                        .version("0.11")
	                        .description("Sample app Spring Boot 3 with Swagger")
	                        .termsOfService("http://swagger.io/terms/")
	                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));

	    }
}  
