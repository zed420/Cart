package com.softoffice.cart;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.softoffice.cart.controller.CategoryController;
import com.softoffice.cart.service.CategoryService;

@SpringBootTest
class CartApplicationTests {
	
	
	@Autowired
	CategoryController cc;
	
	@Autowired
	CategoryService cs;
	

	@Test
	public void contextLoads() {
		Assertions.assertThat(cc).isNotNull();
		Assertions.assertThat(cs).isNotNull();
	}
}
