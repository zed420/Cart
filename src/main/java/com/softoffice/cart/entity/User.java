package com.softoffice.cart.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
    private Integer userId;
    private String userType;
    private String fullName;
    //@Column(name = "email", nullable = false, updatable= false)
    private String email;
    private String password;
    private Boolean status;
    private Date createdDate = new Date();
	
	@OneToOne (cascade = CascadeType.ALL)
	private UserDetails userDetails;
	
	@OneToMany
	private Set<Order> orderSet;

}
