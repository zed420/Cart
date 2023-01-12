package com.softoffice.cart.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "order")
public class Order implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer ordId;
	private Integer ordNumber = orderNumber();
	private Date createdDate = new Date();
	private String ordBy;//logged in user name
	
	@ManyToOne
	private User user;
	
	private int orderNumber() {
		int min = 1;
		int max = 100000000;
		int random_int = (int) (Math.random() * (max - min + 1) + min);
		
		return random_int;
	}

}
