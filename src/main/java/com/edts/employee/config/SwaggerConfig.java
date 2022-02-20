package com.edts.employee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {
	
	@Bean
	  public OpenAPI springShopOpenAPI() {
	      return new OpenAPI()
	              .info(new Info().title("EDTS API")
	              .description("Employee sample application")
	              .version("v0.0.1")
	              .license(new License().name("Ade Nur Hidayat").url("https://adenurhidayat.com/")))
	              .externalDocs(new ExternalDocumentation()
	              .description("Employee Edts Sample Application")
	              .url("https://adenurhidayat.com/"));
	  }

}
