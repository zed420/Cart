package com.softoffice.cart.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softoffice.cart.entity.Category;
import com.softoffice.cart.service.CategoryService;

@RestController
public class CategoryRestController {

	@Autowired
	CategoryService cs;
	
	@GetMapping("/allCategories")
	public List<Category> getAllCategories() {
		return cs.getAllCategories();
	}
	
	@GetMapping("/getCat/{id}")
	public Category getCat(@PathVariable("id") Integer id) {
		return cs.getCategoryById(id);
	}
	
	@PostMapping("/addCat")
	public Category saveCat(Category cat) {
		return cs.addNewCategory(cat);
	}
	
	@GetMapping("/remove/{id}")
	public Integer removeCat(@PathVariable("id") Integer id) {
		return cs.removeById(id);
	}
	
	@PutMapping("/editCat/{catName}/{id}")
	public Integer editCat(@PathVariable("catName") String catName, @PathVariable("id") Integer id) {
		return cs.updateById(catName, id);
	}
	
}
