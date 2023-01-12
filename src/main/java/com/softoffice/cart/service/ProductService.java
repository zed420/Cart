package com.softoffice.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softoffice.cart.entity.Category;
import com.softoffice.cart.entity.Products;
import com.softoffice.cart.repository.ProductsRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductsRepository pr;
	
	public List<Products> getAllProducts(){
		return pr.findAll();
	}
	
	public Products saveProd(Products products) {
		return pr.save(products);
	}
	
	public Products getProdById(Integer prodId) {
		return pr.findByProdId(prodId);
	}
	
	public List<Products> getProdByCat(Category cat){
		return pr.findByCat(cat);
	}
	
	public Integer updateProdName(String name, Integer id) {
		return pr.updateProdNameById(name, id);
	}
}
