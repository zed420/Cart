package com.softoffice.cart.controller.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.softoffice.cart.entity.Category;
import com.softoffice.cart.repository.CategoryRepository;
import com.softoffice.cart.service.CategoryService;

@WebMvcTest(CategoryRestController.class)
public class TestCategoryRestController {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CategoryService catServ;
	
	@MockBean
	private CategoryRepository catRep;
	
	@Test 
 	public void testListOfCategories() throws Exception {
		List<Category> catlist = new ArrayList<>();
		catlist.add(new Category(1, "Cars"));
		catlist.add(new Category(2, "TVs"));
		catlist.add(new Category(9, "MotorBikes"));
		catlist.add(new Category(15, "Smart Phone"));
		
		Mockito.when(catServ.getAllCategories()).thenReturn(catlist);
		String url = "/categories/list";
		MvcResult mvcResult = mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();
		
		byte[] bytes = mvcResult.getResponse().getContentAsByteArray();
		Path path = Paths.get("Categories.xlsx");
		Files.write(path, bytes);
	  }
}
