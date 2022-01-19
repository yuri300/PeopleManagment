package com.br.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.br.spring.model.Phone;

public interface PhoneRepository extends CrudRepository<Phone, Long>{
	
	@Query("select p from Phone p where p.person.id = ?1")
	public List<Phone> getPhones(Long personId);
}
