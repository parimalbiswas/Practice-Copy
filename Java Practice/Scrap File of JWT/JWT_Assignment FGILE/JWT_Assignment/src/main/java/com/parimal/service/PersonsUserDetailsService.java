package com.parimal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.parimal.model.Person;
import com.parimal.repository.PersonRepo;

@Service
public class PersonsUserDetailsService implements UserDetailsService
{
	@Autowired
	private PersonRepo pRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{

		Optional<Person> opt = pRepo.findByUsername(username);

		if (opt.isEmpty())
		{
			throw new BadCredentialsException("User Details Not Found with this username");
		}

		Person person = opt.get();

		List<GrantedAuthority> authorities = new ArrayList<>();

		return new User(person.getUsername(), person.getPassword(), authorities);
	}

}
