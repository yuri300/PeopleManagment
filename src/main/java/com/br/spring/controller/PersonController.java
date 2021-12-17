package com.br.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.br.spring.model.Person;
import com.br.spring.repository.PersonRepository;

@Controller
public class PersonController {
	
	@Autowired
	private PersonRepository personRepository;

	@RequestMapping(method = RequestMethod.GET, value = "/registerPerson")
	public String begin() {
		return "register/registerPerson";
	}
	@RequestMapping(method = RequestMethod.POST, value = "/savePerson")
	public String savePerson(Person person) {
		personRepository.save(person);
		return "register/registerPerson";
	}
}
