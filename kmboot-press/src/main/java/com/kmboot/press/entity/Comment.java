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
 * <p>
 * Comment<br>
 * the feedback to the post
 * <p/>
 * 
 * @author meadlai
 * @since 0.0.1
 * @create at 9:29:26 PM, Mar 5, 2020
 */
@Entity
@Data
@SequenceGenerator(name = "seq_comment", initialValue = 1, allocationSize = 1)
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_comment")
	private Long id;

}
