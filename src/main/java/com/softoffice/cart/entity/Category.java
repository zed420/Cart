package com.softoffice.cart.entity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
@Table(name = "category")
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Integer catId;
	private String catName;
	private String catDescription;
	private Date createdDate = new Date();
	
	public Category() {}
	public Category(int catId, String catName, String catDescription) {
		super();
		this.catId = catId;
		this.catName = catName;
		this.catDescription = catDescription;
	}


	@OneToMany(mappedBy = "cat", orphanRemoval = true, cascade = CascadeType.REMOVE)
	@JsonBackReference
	private List<Products> prolist;
}
