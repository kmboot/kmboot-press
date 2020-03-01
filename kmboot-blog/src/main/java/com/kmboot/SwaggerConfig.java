package com.kmboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @className: SwaggerConfig
 * @description: Swagger2
 * @author: Mead
 * @since February-23, 2020
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Autowired
	private SiteConfig blogConfig;

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).pathMapping("/dev-api")
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
				.paths(PathSelectors.any()).build();
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title(blogConfig.getTitle())
				.description(blogConfig.getDescription())
				.contact(new Contact(blogConfig.getContactName(), blogConfig.getContactLinkUrl(), blogConfig.getContactEmail()))
				.version(blogConfig.getVersion()).build();
	}


}
