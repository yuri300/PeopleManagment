package com.br.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.br.spring.model.Phone;

public interface PhoneRepository extends CrudRepository<Phone, Long>{

}
