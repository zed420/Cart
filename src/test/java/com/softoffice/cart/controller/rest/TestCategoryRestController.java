package com.softoffice.cart.controller.rest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.softoffice.cart.entity.Category;
import com.softoffice.cart.service.CategoryService;

@RunWith(SpringRunner.class)
@WebMvcTest(CategoryRestController.class)
public class TestCategoryRestController {
	
	@MockBean
    CategoryService cs;
	
    @Autowired
    MockMvc mockMvc;
    
    @Test
    public void test_saveCategory() throws Exception {
    	
    	Category cat = new Category(1,"Cars","Old");
        when(cs.addNewCategory(cat)).thenReturn(cat);
        mockMvc.perform(post("/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(cat)))
                .andExpect(status().isOk());
    }
    
    @Test
    public  void test_getCategoryList() throws Exception {
        
    	List<Category> catlist = Arrays.asList(new Category(1, "Cars", "Old"),
                								new Category(2, "TVs", "Black & White"));
        when(cs.getAllCategories()).thenReturn(catlist);
        mockMvc.perform(get("/list")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].catId").value(1))
        		.andExpect(jsonPath("$[0].catName").value("Cars"));
    }
    
    @Test
    public void test_getCategoryById() throws Exception {
        
    	Category cat = new Category(2,"TVs","Black & White");
        when(cs.getCategoryById(2)).thenReturn(cat);
        mockMvc.perform(get("/{id}",2)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.catName").value("TVs"));
    }
    
    
 

}