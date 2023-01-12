package com.softoffice.cart;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.softoffice.cart.controller.HomeController;
import com.softoffice.cart.controller.UserController;

@SpringBootTest
class CartApplicationTests {
	
	@Autowired
	UserController uc;
	
	@Autowired
	HomeController hc;

	@Test
	public void contextLoads() {
		Assertions.assertThat(uc).isNotNull();
		Assertions.assertThat(hc).isNotNull();
	}
	

}
