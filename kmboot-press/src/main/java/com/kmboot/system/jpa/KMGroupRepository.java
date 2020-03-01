/*
 * Copyright 2019-2020, the original author or authors.
 * kmboot.com, jbpm.org, All Right Reserved.
 *
 */
package com.kmboot.system.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kmboot.system.entity.KMGroup;

/**
 * <p>
 * KMGroupRepository
 * <p/>
 * 
 * @author meadlai
 * @since 0.0.1
 * @create at 9:21:38 AM, Mar 1, 2020
 */
@Repository
public interface KMGroupRepository extends JpaRepository<KMGroup, Long> {

}
