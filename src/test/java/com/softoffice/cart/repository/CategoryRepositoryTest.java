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

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class CategoryRepositoryTest {

	@Autowired
	CategoryRepository cRep;
	
	Category cat;
	List<Category> catlist;
	
	@BeforeEach
	public void setUp() {
		cat = new Category();
	}
	
	@Test
	public void testFindAll() {
		catlist = cRep.findAll();
		assertNotNull(catlist);
		assertEquals(catlist.size(), 2);
	}

	@Test
	public void testFindByCatId() {
		Category cat = cRep.findByCatId(2);
		assertNotNull(cat);
	}

	@Test
	public void testFindByCatName() {
		catlist = cRep.findByCatName("TVs");
		assertNotNull(catlist);
	}

	@Test
	public void testSave() {
		
		cat.setCatDescription("Blue Color");
		cat.setCatName("TVs Tests");
		Category savedCat =  cRep.save(cat);
		
		assertNotNull(savedCat);
		assertTrue(cat.getCatId() > 0);
	}

}
