/*
 * Copyright 2019-2020, the original author or authors.
 * kmboot.com, jbpm.org, All Right Reserved.
 *
 */
package com.kmboot.system.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;


/**
 * <p>
 * KMGroupRepository
 * <p/>
 * 
 * @author meadlai
 * @since 0.0.1
 * @create at 9:21:38 AM, Mar 1, 2020
 */
@Entity
@Data
@SequenceGenerator(name = "seq_group", initialValue = 1, allocationSize = 1)
public class KMGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_group")
	private Long id;

	private String name;

	private Boolean active;
}
