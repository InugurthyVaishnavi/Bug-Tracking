package com.traning.bugtracker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Component
public class SwaggerConfiguration implements WebMvcConfigurer{

	 @Bean
	  public Docket categoryApi() {
	    return new Docket(DocumentationType.SWAGGER_2).select()
//	    		.paths(PathSelectors.ant("/bug/"))
	    		.apis(RequestHandlerSelectors.basePackage("com.traning.bugtracker"))
	    		.build();
}
}
