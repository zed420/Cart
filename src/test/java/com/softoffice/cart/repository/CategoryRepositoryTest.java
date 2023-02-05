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
		assertEquals(3, catlist.size());
	}

	@Test
	public void testFindByCatId() {
		Category cat = cRep.findByCatId(9);
		assertNotNull(cat);
		assertEquals("MotorBikes", cat.getCatName());
	}

	@Test
	public void testFindByCatName() {
		Category cat = cRep.findByCatName("TVs");
		assertNotNull(cat);
		assertEquals("TVs", cat.getCatName());
	}

	@Test
	public void testSave() {
		cat.setCatDescription("White Color");
		cat.setCatName("Mobile Phone");
		Category savedCat =  cRep.save(cat);
		
		assertNotNull(savedCat);
		assertTrue(cat.getCatId() > 0);
	}
	
	@Test
	public void removeCat() {
		cRep.removeById(9);
		cat = cRep.findByCatId(9);
		assertNull(cat);
	}

}
