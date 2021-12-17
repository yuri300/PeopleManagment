package com.br.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.br.spring.model.Person;

@Repository
@Transactional
public interface PersonRepository extends CrudRepository<Person, Long>{

}
