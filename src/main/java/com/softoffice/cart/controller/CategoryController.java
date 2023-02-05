package com.softoffice.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.softoffice.cart.entity.Category;
import com.softoffice.cart.service.CategoryService;

@Controller
@RequestMapping("/cat")
public class CategoryController {
	
	public static final String CAT_LIST = "listOfCategories.html";
	
	@Autowired
	private CategoryService cs;
	
	@GetMapping("/list")
	public String getAllCategories(Model model) {
		List<Category> catList = cs.getAllCategories();
		model.addAttribute("catList", catList);
		return CAT_LIST;
	}
	
	@PostMapping("/add")
	public String addNewCat(Category category) {
		cs.addNewCategory(category);
		return "redirect:/catList";
	}
	
}
