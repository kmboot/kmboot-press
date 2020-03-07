/*
 * Copyright 2019-2020, the original author or authors.
 * kmboot.com, jbpm.org, All Right Reserved.
 *
 */
package com.kmboot.press.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

/**
 * <p> Post<br>
 * the articles content
 * <p/>
 * @author meadlai
 * @since 0.0.1
 * @create at 9:29:02 PM, Mar 5, 2020
 */
@Entity
@Data
@SequenceGenerator(name = "seq_post", initialValue = 1, allocationSize = 1)
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_post")
	private Long id;
}
