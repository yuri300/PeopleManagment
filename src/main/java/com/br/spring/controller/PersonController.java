package com.br.spring.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.br.spring.model.Person;
import com.br.spring.model.Phone;
import com.br.spring.repository.PersonRepository;
import com.br.spring.repository.PhoneRepository;

@Controller
public class PersonController {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private PhoneRepository phoneRepository;
	
	@RequestMapping(method = RequestMethod.GET, value = "/registerPerson")
	public ModelAndView begin() {
		ModelAndView mv = new ModelAndView("register/registerPerson");
		Iterable<Person> personIt = personRepository.findAll();
		mv.addObject("people", personIt);
		mv.addObject("personobj", new Person());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/savePerson")
	public ModelAndView savePerson(Person person) {
		personRepository.save(person);
		
		ModelAndView mv = new ModelAndView("register/registerPerson");
		Iterable<Person> personIt = personRepository.findAll();
		mv.addObject("people", personIt);
		mv.addObject("personobj", new Person());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/listPeople")
	public ModelAndView People() {
		ModelAndView mv = new ModelAndView("register/registerPerson");
		Iterable<Person> personIt = personRepository.findAll();
		mv.addObject("people", personIt);
		mv.addObject("personobj", new Person());
		return mv;
	}
	
	@GetMapping("/editPerson/{idPerson}")
	public ModelAndView Edit(@PathVariable("idPerson") Long idPerson) {
		Optional<Person> person = personRepository.findById(idPerson);
		ModelAndView mv = new ModelAndView("register/registerPerson");
		mv.addObject("personobj", person.get());
		return mv;
	}
	
	@GetMapping("/deletePerson/{idPerson}")
	public ModelAndView Delete(@PathVariable("idPerson") Long idPerson) {
		
		personRepository.deleteById(idPerson);
		ModelAndView mv = new ModelAndView("register/registerPerson");
		mv.addObject("people", personRepository.findAll());
		mv.addObject("personobj", new Person());
		return mv;
	}
	
	@PostMapping("**/searchPerson")
	public ModelAndView searchPerson(@RequestParam("nameSearch") String nameSearch) {
		ModelAndView mv = new ModelAndView("register/registerPerson");
		mv.addObject("people", personRepository.findPersonByName(nameSearch));
		mv.addObject("personobj", new Person());
		return mv;
	}
	
	@GetMapping("/Phones/{idPerson}")
	public ModelAndView Phones(@PathVariable("idPerson") Long idPerson) {
		Optional<Person> person = personRepository.findById(idPerson);
		ModelAndView mv = new ModelAndView("register/Phones");
		mv.addObject("personobj", person.get());
		mv.addObject("phones", phoneRepository.getPhones(idPerson));
		return mv;
	}
	
	@PostMapping("**/addPhonePerson/{personId}")
	public ModelAndView addPhonePerson(Phone phone,@PathVariable("personId") Long personId) {
		Person person = personRepository.findById(personId).get();
		phone.setPerson(person);
		phoneRepository.save(phone);
		ModelAndView mv = new ModelAndView("register/Phones");
		mv.addObject("personobj", person);
		mv.addObject("phones", phoneRepository.getPhones(personId));
		return mv;
	}
	
	@GetMapping("/deletePhone/{idPhone}")
	public ModelAndView deletePhone(@PathVariable("idPhone") Long idPhone) {
		
		Person person = phoneRepository.findById(idPhone).get().getPerson();
		
		phoneRepository.deleteById(idPhone);
		
		ModelAndView mv = new ModelAndView("register/phones");
		mv.addObject("personobj", new Person());
		mv.addObject("phones", phoneRepository.getPhones(person.getId()));
		return mv;
	}
}
