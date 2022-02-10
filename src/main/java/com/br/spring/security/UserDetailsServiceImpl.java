package com.br.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.spring.model.UserPerson;
import com.br.spring.repository.UserPersonRepository;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserPersonRepository userPersonRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserPerson userPerson = userPersonRepository.findUserByLogin(username);
		
		if(userPerson == null) {
			throw new UsernameNotFoundException("Username and/or password invalid.");
		}
		return new User(userPerson.getLogin(), userPerson.getPassword(),
				userPerson.isEnabled(), true, true,
				true, userPerson.getAuthorities());
	}

}
