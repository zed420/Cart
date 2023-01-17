package com.softoffice.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.softoffice.cart.entity.Category;
import com.softoffice.cart.service.CategoryService;

@Controller
public class CategoryController {
	
	public static final String CAT_LIST = "listOfCategories.html";
	public static final String REACT_HOME = "react.html";
	
	@Autowired
	private CategoryService cs;
	
	@GetMapping("/catList")
	public String getAllCategories(Model model) {
		List<Category> catList = cs.getAllCategories();
		model.addAttribute("catList", catList);
		return CAT_LIST;
	}
	
	@PostMapping("/addNewCat")
	public String addNewCat(Category category) {
		cs.addNewCategory(category);
		return "redirect:/catList";
	}
	
	@GetMapping("/react_home")
	public String reactHome() {
		return REACT_HOME;
	}
	
}
