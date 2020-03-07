/*
 * Copyright 2019-2020, the original author or authors.
 * kmboot.com, jbpm.org, All Right Reserved.
 *
 */
package com.kmboot.dynamic;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * PropertiesLoader
 * <p/>
 * 
 * @author meadlai
 * @since 0.0.1
 * @create at 10:44:56 PM, Mar 1, 2020
 */
@Slf4j
public final class PropertiesLoader {
	public static final String KMBOOT_SETTING = "kmboot_setting";
	public static final String BASE_PACKAGES = "kmboot.basePackages";
	public static final String COMPONENT_SCAN = "kmboot.ComponentScan";
	//
	private static final Properties config = new Properties();
	private static String basePackages = "";

	static {
		String settingFileName = "application.properties";
		String prop = System.getProperty(KMBOOT_SETTING);
		if (StringUtils.isNotBlank(prop)) {
			settingFileName = prop;
			try (final InputStream stream = new FileInputStream(settingFileName)) {
				config.load(stream);
				basePackages = config.getProperty(BASE_PACKAGES);
				log.info("basePackages is: ", basePackages);
			} catch (Exception ex) {
				log.warn("## Load settings file: {}, error: {}", settingFileName, ex.getMessage());
			}
		} else {
			try (final InputStream stream = PropertiesLoader.class.getResourceAsStream(settingFileName)) {
				config.load(stream);
				basePackages = config.getProperty(BASE_PACKAGES);
				log.info("basePackages is: ", basePackages);
			} catch (Exception ex) {
				log.warn("## Load settings file: {}, error: {}", settingFileName, ex.getMessage());
			}
		}

	}

	public static List<String> getBasePackages() {
		List<String> list = new ArrayList<>();
		if (StringUtils.isNoneBlank(basePackages)) {
			list.addAll(Arrays.asList(basePackages.split(",")));
		}
		return list;
	}

}
