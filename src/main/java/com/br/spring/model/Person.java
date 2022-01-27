package com.br.spring.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Person implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotEmpty(message = "The name can't be empty.")
	@NotNull(message = "The name can't be null.")
	private String name;
	
	@NotEmpty(message = "The last name can't be empty.")
	@NotNull(message = "The last name can't be null.")
	private String lastName;
	
	@OneToMany(mappedBy = "person", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<Phone> phone;

	
	public List<Phone> getPhone() {
		return phone;
	}

	public void setPhones(List<Phone> phone) {
		this.phone = phone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
