package com.edts.employee.config.aspect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.Environment;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@EnableAspectJAutoProxy
public class AspectConfig {
private ObjectMapper objectMapper;
	
	public AspectConfig(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
   }
	
		/**
	   * Logger aspect bean.
	   * @param environment the environment
	   * @return the logger aspect
	   */
	   @Bean
	   public LoggingAspect loggingAspect(@Lazy Environment environment) {
	      return new LoggingAspect(objectMapper);
	   }
}
