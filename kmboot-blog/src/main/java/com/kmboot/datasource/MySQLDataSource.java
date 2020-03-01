/*
 * Copyright 2019-2020, the original author or authors.
 * kmboot.com, jbpm.org, All Right Reserved.
 *
 */
package com.kmboot.datasource;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySQLDataSource {

	@Bean("mysqlDatasource")
	@ConfigurationProperties(prefix = "mysql.datasource")
	@ConditionalOnMissingBean(DataSource .class)
	public DataSource getDataSource() {
		return DataSourceBuilder.create().build();
	}

}
