/*
 * Copyright 2019-2020, the original author or authors.
 * kmboot.com, jbpm.org, All Right Reserved.
 *
 */
package com.kmboot.datasource;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * <p>
 * EntityManagerConfig
 * <p/>
 * add entityManagerFactoryRef name here, or rename the "emf" to
 * "entityManagerFactory"
 * 
 * 
 * @author meadlai
 * @since 0.0.1
 * @create at 10:56:15 AM, Mar 1, 2020
 */

@Configuration
@EnableJpaRepositories(basePackages = { "com.kmboot.system.jpa" }, entityManagerFactoryRef = "emf")
@EntityScan("com.kmboot.system.jpa")
public class EntityManagerConfig {

	@Autowired
	private DataSource dataSource;

	public static final String PKG_ENTITY = "com.kmboot.system.jpa";
	public static final String FILE_PERSISTENCE = "classpath:/META-INF/persistence.xml";
	public static final String UNIT_NAKE = "jpa_unit_kmboot";

	/**
	 * <p>
	 * entity manager factory
	 * </p>
	 * 
	 * @return
	 */
	@Bean("emf")
	public LocalContainerEntityManagerFactoryBean kmJpaEntityManagerFactoryBean() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		// vendorAdapter.setDatabase(Database.ORACLE);
		vendorAdapter.setShowSql(true);
		vendorAdapter.setGenerateDdl(true);
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(dataSource);
		entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
		entityManagerFactory.setPackagesToScan(PKG_ENTITY);
		entityManagerFactory.setPersistenceXmlLocation(FILE_PERSISTENCE);
		entityManagerFactory.setPersistenceUnitName(UNIT_NAKE);
		Properties properties = new Properties();
		properties.setProperty("hibernate. jdbc.fetch_size", "1000");
		entityManagerFactory.setJpaProperties(properties);
		return entityManagerFactory;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}

}
