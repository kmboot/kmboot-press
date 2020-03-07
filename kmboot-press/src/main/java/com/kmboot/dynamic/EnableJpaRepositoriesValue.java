/*
 * Copyright 2019-2020, the original author or authors.
 * kmboot.com, jbpm.org, All Right Reserved.
 *
 */
package com.kmboot.dynamic;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.config.BootstrapMode;
import org.springframework.data.repository.config.DefaultRepositoryBaseClass;
import org.springframework.data.repository.query.QueryLookupStrategy.Key;


/**
 * <p>
 * EnableJpaRepositoriesValue
 * <p/>
 * 
 * @author meadlai
 * @since 0.0.1
 * @create at 9:07:17 PM, Mar 1, 2020
 */
public class EnableJpaRepositoriesValue implements EnableJpaRepositories {
	@Override
	public Class<? extends Annotation> annotationType() {
		return EnableJpaRepositoriesValue.class;
	}

	@Override
	public String[] value() {
		return EMPTY_STRING_ARRAY;
	}

	@Override
	public String[] basePackages() {
		List<String> list = new ArrayList<>();
		list.add("com.kmboot.system.jpa");
		list.addAll(PropertiesLoader.getBasePackages());
		return list.toArray(new String[0]);
	}

	@Override
	public Class<?>[] basePackageClasses() {
		return null;
	}

	@Override
	public Filter[] includeFilters() {
		return null;
	}

	@Override
	public Filter[] excludeFilters() {
		return null;
	}

	@Override
	public String repositoryImplementationPostfix() {
		return "Impl";
	}

	@Override
	public String namedQueriesLocation() {
		return "";
	}

	@Override
	public Key queryLookupStrategy() {
		return Key.CREATE_IF_NOT_FOUND;
	}

	@Override
	public Class<?> repositoryFactoryBeanClass() {
		return JpaRepositoryFactoryBean.class;
	}

	@Override
	public Class<?> repositoryBaseClass() {
		return DefaultRepositoryBaseClass.class;
	}

	@Override
	public String entityManagerFactoryRef() {
		return "emf";
	}

	@Override
	public String transactionManagerRef() {
		return "transactionManager";
	}

	@Override
	public boolean considerNestedRepositories() {
		return false;
	}

	@Override
	public boolean enableDefaultTransactions() {
		return true;
	}

	@Override
	public BootstrapMode bootstrapMode() {
		return BootstrapMode.DEFAULT;
	}

	@Override
	public char escapeCharacter() {
		return '\\';
	}

	private static final String[] EMPTY_STRING_ARRAY = new String[] {};

	public String toString() {
		//
		return StringUtils.join(this.basePackages(), ";");
	}
}
