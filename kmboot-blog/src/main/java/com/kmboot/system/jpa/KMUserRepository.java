/*
 * Copyright 2019-2020, the original author or authors.
 * kmboot.com, jbpm.org, All Right Reserved.
 *
 */
package com.kmboot.system.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kmboot.system.entity.KMUser;

/**
 * <p>
 * KMUserRepository
 * <p/>
 * 
 * @author meadlai
 * @since 0.0.1
 * @create at 9:21:55 AM, Mar 1, 2020
 */
@Repository
public interface KMUserRepository extends JpaRepository<KMUser, Long> {

}
