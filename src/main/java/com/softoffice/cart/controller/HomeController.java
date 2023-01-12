package com.softoffice.cart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	public static final String INDEX = "index.html"; 
	
	@GetMapping("/")
	public String getAll() {
		return INDEX;
	}
}
