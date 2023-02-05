package com.softoffice.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softoffice.cart.entity.Category;
import com.softoffice.cart.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository cr;
	
	public Category addNewCategory(Category category) {
		return cr.save(category);
	}
	
	public List<Category> getAllCategories(){
		return cr.findAll();
	}
	
	public Category getCategoryById(Integer catId) {
		return cr.findByCatId(catId);
	}
	
	public Category getCategoryByName(String catName){
		return cr.findByCatName(catName);
	}
	
	@Transactional
	public Integer removeById(Integer catId) {
		return cr.removeById(catId);
	}
	
	//@Transactional
	public Integer updateById(String catName, Integer catId) {
		return cr.updateById(catName, catId);
	}
}
