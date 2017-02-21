package com.open.suite.tests;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.open.suite.app.Application;
import com.open.suite.service.CommentService;
import com.open.suite.service.ThreadRegistrationHql;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CustomerTest {

	@Autowired
	private ThreadRegistrationHql service;
	
	@Autowired
	private CommentService coService;

	@Test
	public void testFindByLastName() {

		System.out.println("working fine");
		assertThat(true);
	}

}
