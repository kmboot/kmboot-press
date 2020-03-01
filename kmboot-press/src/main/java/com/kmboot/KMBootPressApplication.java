package com.kmboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@ComponentScan({ "com.kmboot" })
//@ServletComponentScan
@EnableAutoConfiguration
@Slf4j
public class KMBootPressApplication {

	public static void main(String[] args) {
		log.info("KMBootPressApplication is sarting...");
		SpringApplication.run(KMBootPressApplication.class, args);
		log.info("KMBootPressApplication statrs success!!!");
	}

}
