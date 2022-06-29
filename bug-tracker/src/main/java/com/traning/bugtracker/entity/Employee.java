package com.traning.bugtracker.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

//class declaration

@Entity(name = "Employee")
@Data
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	// Fields
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "designation")
	private String designation;

	//@OneToOne(cascade= {CascadeType.REFRESH, CascadeType.PERSIST})
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Bug> bugs;

}
