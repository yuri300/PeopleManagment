package com.br.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.br.spring.model.UserPerson;

@Repository
@Transactional
public interface UserPersonRepository extends CrudRepository<UserPerson, Long>{

	@Query("select u from UserPerson u where u.login = ?1")
	UserPerson findUserByLogin(String login);
}
