package com.softoffice.cart.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softoffice.cart.entity.User;
import com.softoffice.cart.service.UserService;

@RestController
public class UserRestController {

	@Autowired
	UserService uservice;
	
	@GetMapping("/allUsers")
	public List<User> getAllUsers() {
		return uservice.getAllUsers();
	}
	
	@PostMapping("/addNewUser")
	public User addNewUser(User user) {
		return uservice.addNewUser(user);
	}
	
	@PutMapping("/updateUserFullName/{name}/{id}")
	public Integer updateName(@PathVariable("name") String name, @PathVariable("id") Integer id) {
		return uservice.updateUserFullName(name, id);
	}
	
	@PutMapping("/updateUserEmail/{email}/{id}")
	public Integer updateEmail(@PathVariable("email") String email, @PathVariable("id") Integer id) {
		return uservice.updateUserEmail(email, id);
	}
	
	@GetMapping("/getUser/{id}")
	public List<User> getUserById(@PathVariable("id") Integer id){
		return uservice.getByUserId(id);
	}
	
	@GetMapping("/getName/{name}")
	public List<User> getUserByName(@PathVariable("name") String name) {
		return uservice.getUserByName(name);
	}
}
