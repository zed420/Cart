package com.softoffice.cart.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softoffice.cart.entity.Category;
import com.softoffice.cart.entity.Products;
import com.softoffice.cart.service.ProductService;

@RestController
public class ProductRestController {

	@Autowired
	ProductService ps;
	
	@GetMapping("/allProds")
	public List<Products> getAllProds(){
		return ps.getAllProducts();
	}
	
	@PostMapping("/saveProd")
	public Products saveProd(Products prod) {
		return ps.saveProd(prod);
	}
	
	@GetMapping("/getProd/{id}")
	public Products getProdById(@PathVariable("id") Integer id) {
		return ps.getProdById(id);
	}
	
	@GetMapping("/getProdByCat/{cat}")
	public List<Products> getProdByCatId(@PathVariable("cat") Category cat){
		return ps.getProdByCat(cat);
	}
	
	@PutMapping("/updateProd/{name}/{id}")
	public Integer updateProd(@PathVariable("name") String name, @PathVariable("id") Integer id) {
		return ps.updateProdName(name, id);
	}
	
}
