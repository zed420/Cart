package com.softoffice.cart.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.softoffice.cart.entity.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UserRepTest {

	@Autowired
	UserRepository uRep;
	
	@Test
	public void checkUserRepository() {
		assertThat(uRep).isNotNull();
	}
	
	@Test
	public void save_a_player() {
		User user = uRep.save(new User());
		user.setFullName("Saif2 Ali Khan");
		user.setEmail("saif2@gmail.com");
		User saveUser = uRep.save(user);
		
		assertNotNull(saveUser);
	}

	@Test
	public void should_find_all_users() {
		List<User> userList = new ArrayList<>();
		userList = uRep.findAll();
		assertThat(userList).isNotEmpty();
		assertThat(userList.size()).isEqualTo(4);
	}
	
	@Test
	public void should_find_these_users() {
		
		String a = null, b=null,c = null;
		List<User> userList = uRep.findAll();
			 a = userList.get(0).getFullName();
			 b = userList.get(1).getFullName();
			 c = userList.get(2).getFullName();

		assertThat(a).isEqualTo("Saeed Rana");
		assertThat(b).isEqualTo("Zaheer Ahmed");
		assertThat(c).isEqualTo("Zulfi Baig");
	}

	@Test
	public void test_find_user_by_email() {
		String email = null;
		List<User> userList = uRep.findAll();
		email = userList.get(0).getEmail();
		assertThat(email).isEqualTo("saeed@gmail.com");
	}
}
