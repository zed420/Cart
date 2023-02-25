package com.softoffice.cart.controller.rest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.softoffice.cart.entity.Products;
import com.softoffice.cart.service.ProductService;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductRestController.class)
class ProductRestControllerTest {
	
	@MockBean
	ProductService ps;
	
    @Autowired
    MockMvc mockMvc;

	@Test
	void testGetAllProds()throws Exception {
	    List<Products> prodlist = Arrays.asList(new Products(1, "Toyota", "red"),
                new Products(2, "Honda", "Black & White"));
        when(ps.getAllProducts()).thenReturn(prodlist);
        mockMvc.perform(get("/prods/list")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].prodId").value(1))
        .andExpect(jsonPath("$[0].prodName").value("Toyota"));
	}

	@Test
	void testSaveProd() throws JsonProcessingException, Exception {
		Products pro = new Products(3,"New Cars","New");
        when(ps.saveProd(pro)).thenReturn(pro);
        mockMvc.perform(post("/prods/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(pro)))
                .andExpect(status().isOk());
	}

	@Test
	void testGetProdById() throws Exception {
		Products pro = new Products(2,"TVs","Black & White");
        when(ps.getProdById(2)).thenReturn(pro);
        mockMvc.perform(get("/prods/get/{id}",2)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.prodName").value("TVs"));
	}

	@Test
	void testGetProdByCatId() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateProd() {
		fail("Not yet implemented");
	}

	@Test
	void testRemoveProd() throws Exception {
		Products pro = new Products(31,"Smart Phones","Touch Screen");
        Mockito.when(ps.removeById(pro.getProdId())).thenReturn(31);
        mockMvc.perform(get("/prods/remove/31")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(pro)))
                .andExpect(status().isOk());
	}

}
