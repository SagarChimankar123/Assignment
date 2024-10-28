package com.infy.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;

//swagger ui configuration
@OpenAPIDefinition
@Configuration
public class OpenApiConfig {

	@Bean
    public OpenAPI baseOpenAPI(){
		
		Components components = new Components()
	            .addSecuritySchemes("basicScheme", new SecurityScheme()
	                .type(SecurityScheme.Type.HTTP)
	                .scheme("basic"));
		
        return new OpenAPI().components(components)
                            .info(new Info()
                            .title("Springboot_Swagger Project OpenAPI Docs")
                            .version("1.0.0").description("Doc Description"));
    }

}