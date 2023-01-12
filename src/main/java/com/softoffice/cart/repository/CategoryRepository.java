package com.softoffice.cart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.softoffice.cart.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	List<Category> findAll();
	Category findByCatId(Integer catId);
	List<Category> findByCatName(String catName);
	
	@Modifying
    @Query("DELETE FROM Category WHERE catId = ?1")
	Integer removeById(Integer catId);
	
	@Transactional
	@Modifying
    @Query("UPDATE Category SET catName = ?1 WHERE catId = ?2")
	Integer updateById(String catName, Integer catId);
}
