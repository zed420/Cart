package com.softoffice.cart.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "userDetails")
public class UserDetails implements Serializable {
	 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
    private Integer userDetailsId;
	private String userAddress;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate dateOfBirth;
	private String NINumber;
	private String bankDetails;
	private String previousSchool;
	private String medicalInfo;
	private String attendance;
	private String behaviouralInfo;
	
	private String fileName;
	private String fileType;
	@Lob
	private byte[] userImage; 
	
	@OneToOne
	private User users;

}
