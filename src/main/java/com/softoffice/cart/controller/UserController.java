package com.softoffice.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.softoffice.cart.entity.User;
import com.softoffice.cart.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userSer;
	
	public static final String USER_LIST = "listOfUsers.html";
	
	@GetMapping("/userList")
	public String getAllUsers(Model model) {
		List<User> userList = userSer.getAllUsers();
		model.addAttribute("userList", userList);
		return USER_LIST; 
	}
	
	@PostMapping("/addUser")
	public String addUser(Model model, User user) {
		userSer.addNewUser(user);
		return "redirect:/userList";
	}
	
}
