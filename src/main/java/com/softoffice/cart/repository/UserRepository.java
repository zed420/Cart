package com.softoffice.cart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.softoffice.cart.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	List<User> findAll();
	
	List<User> findByFullName(String fullName);
	
	User findByEmail(String email);
	
	List<User> findByUserId(Integer userId);
	
	@Transactional
	@Modifying
	@Query("UPDATE User u SET u.fullName = ?1 WHERE u.userId = ?2")
	Integer updateUserFullName(String fullName,Integer userId);
	
	@Transactional
	@Modifying
	@Query("UPDATE User u SET u.email = ?1 WHERE u.userId = ?2")
	Integer updateUserEmail(String email, Integer userId);
}
