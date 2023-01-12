package com.softoffice.cart.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.softoffice.cart.entity.Category;
import com.softoffice.cart.entity.Products;
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class ProductsRepositoryTest {
	
	@Autowired
	ProductsRepository pr;

	Products prod;
	Category cat;
	List<Products> prodlist;
	
	@BeforeEach
	public void setUp() {
		prod = new Products();
	}
	
	@Test
	void testFindAll() {
		prodlist = pr.findAll();
		assertNotNull(prodlist);
		assertEquals(7, prodlist.size());
	}

	@Test
	void testFindByProdId() {
		prod = pr.findByProdId(80);
		assertNotNull(prod);
	}

	@Test
	void testFindByProdName() {
		prodlist = pr.findByProdName("Samsung TV");
		assertNotNull(prodlist);
		assertEquals("Samsung TV", prodlist.get(0).getProdName());
	}

	@Test
	void testFindByCat() {
		

	}

	@Test
	void testSave() {
		prod = new Products();
		prod.setProdName("New Test save Prod");
		pr.save(prod);
	}

}
