package com.softoffice.cart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.softoffice.cart.entity.Category;
import com.softoffice.cart.entity.Products;

public interface ProductsRepository extends JpaRepository<Products,Integer> {

	List<Products> findAll();
	Products findByProdId(Integer prodId);
	List<Products> findByProdName(String prodName);
	
	//@Query("SELECT p FROM Products p WHERE p.cat.catId = ?1")
	List<Products> findByCat(Category cat);
	
	@Transactional
	@Modifying
	@Query("UPDATE Products p SET p.prodName = ?1 WHERE p.prodId = ?2")
	Integer updateProdNameById(String prodName, Integer prodId);
	
	@Modifying
    @Query("DELETE FROM Products WHERE prodId = ?1")
	Integer removeById(Integer prodId);
}
