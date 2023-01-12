package com.softoffice.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softoffice.cart.entity.User;
import com.softoffice.cart.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRep;

	public List<User> getAllUsers(){
		return userRep.findAll();
	}
	
	public User addNewUser(User user) {
		return userRep.save(user);
	}
	
	public List<User> getUserByName(String name) {
		return userRep.findByFullName(name);
	}
	
	public User getUserByEmail(String email) {
		return userRep.findByEmail(email);
	}
	
	public List<User> getByUserId(Integer userId){
		return userRep.findByUserId(userId);
	}
	
	public Integer updateUserFullName(String fullName, Integer userId) {
		return userRep.updateUserFullName(fullName, userId);
	}
	
	public Integer updateUserEmail(String email, Integer userId) {
		return userRep.updateUserEmail(email, userId);
	}
}
