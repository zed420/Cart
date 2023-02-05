package com.softoffice.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.softoffice.cart.entity.Category;
import com.softoffice.cart.entity.Products;
import com.softoffice.cart.service.ProductService;

@Controller
@RequestMapping("/prod")
public class ProductController {

	@Autowired
	private ProductService ps;
	
	public static final String PROD_LIST = "listOfProducts.html"; 
	
	@GetMapping("/list")
	public String getAllProducts(Model model) {
		List<Products> prodList = ps.getAllProducts();
		model.addAttribute("prodlist", prodList);
		return PROD_LIST;
	}
	
	@PostMapping("/add")
	public String saveOrUpdate(Products products) {
		ps.saveProd(products);
		return "redirect:/prodlist";
	}
	
	@GetMapping("/prodId/{cat}")
	public String getProductsByCat(@PathVariable("cat") Category cat,  Model model) {
		List<Products> prodList = ps.getProdByCat(cat);
		model.addAttribute("prodlist", prodList);
		return PROD_LIST;
	}
	
}
