package com.kmboot;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.kmboot.datasource.EntityManagerConfig;
import com.kmboot.dynamic.DynamicOperator;
import com.kmboot.dynamic.EnableJpaRepositoriesValue;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@ComponentScan({ "com.kmboot" })
@ServletComponentScan({ "com.kmboot" })
@EnableAutoConfiguration
@Slf4j
public class KMBootPressApplication {

	public static void main(String[] args) {
		log.info("KMBootPressApplication is starting...");
		DynamicOperator.alterAnnotationValueJDK8(EntityManagerConfig.class, EnableJpaRepositories.class,
				new EnableJpaRepositoriesValue());
		log.info("running... ");
		SpringApplication.run(KMBootPressApplication.class);
		log.info("KMBootPressApplication starts success!!!");
		EnableJpaRepositories config = EntityManagerConfig.class.getAnnotation(EnableJpaRepositories.class);
		log.info("packages: {}", StringUtils.join(config.basePackages(), "; "));
	}

}
