/*
 * Copyright 2019-2020, the original author or authors.
 * kmboot.com, jbpm.org, All Right Reserved.
 *
 */
package com.kmboot.dynamic;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * DynamicOperator
 * <p/>
 * 
 * @author meadlai
 * @since 0.0.1
 * @create at 9:55:04 PM, Mar 1, 2020
 */
@Slf4j
public class DynamicOperator {

	private static final String ANNOTATION_METHOD = "annotationData";
	private static final String ANNOTATIONS = "annotations";

	static {
		log.info("DynamicOperator static init");
	}

	private DynamicOperator() {
		//
		log.info("DynamicOperator constructor init");

	}

	@SuppressWarnings("unchecked")
	public static void alterAnnotationValueJDK8(Class<?> targetClass, Class<? extends Annotation> targetAnnotation,
			Annotation targetValue) {
		try {
			log.info("alter the class: {}  with it's annotation: {} by the value: {}", targetClass.getName(), targetAnnotation.getName(),
					targetValue.toString());

			Method method = Class.class.getDeclaredMethod(ANNOTATION_METHOD, null);
			method.setAccessible(true);

			Object annotationData = method.invoke(targetClass);

			Field annotations = annotationData.getClass().getDeclaredField(ANNOTATIONS);
			annotations.setAccessible(true);

			Map<Class<? extends Annotation>, Annotation> map = (Map<Class<? extends Annotation>, Annotation>) annotations
					.get(annotationData);
			map.put(targetAnnotation, targetValue);
		} catch (Exception e) {
			log.error("alter annotation excepton", e);
		}
	}

}
