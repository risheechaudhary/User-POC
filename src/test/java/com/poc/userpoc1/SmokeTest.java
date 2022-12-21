package com.poc.userpoc1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.poc.userpoc1.controller.UserController;

@SpringBootTest
public class SmokeTest {

	@Autowired
	private UserController userController;
	
	@Test
	void contextLoads() {
		assertThat(userController).isNotNull();
	}
}
