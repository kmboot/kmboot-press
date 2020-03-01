/*
 * Copyright 2019-2020, the original author or authors.
 * kmboot.com, jbpm.org, All Right Reserved.
 *
 */
package com.kmboot.system.jpa;

import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.kmboot.KMBootPressApplication;
import com.kmboot.system.entity.KMGroup;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * KMGroupRepositoryTest
 * <p/>
 * 
 * @author meadlai
 * @since 0.0.1
 * @create at 10:00:24 AM, Mar 1, 2020
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = KMBootPressApplication.class)
@Slf4j
public class KMGroupRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private KMGroupRepository repository;

	@Test
	@Commit
//	@Rollback(false)
	public void allInOne() {
		KMGroup entity = new KMGroup();
		entity.setName("admin");
		this.repository.save(entity);
		List<KMGroup> list = this.repository.findAll();
		list.stream().map(e -> e.toString()).forEach(log::info);
		Assert.assertNotNull(list);
		Assert.assertTrue("size not empty", list.size() > 0);
//		this.repository.delete(entity);
	}
}
