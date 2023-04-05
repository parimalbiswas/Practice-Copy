package com.parimal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parimal.model.Person;
import com.parimal.repository.PersonRepo;

@RestController
public class LoginController
{
	@Autowired
	private PersonRepo pRepo;

	@GetMapping("/login")
	public ResponseEntity<Person> getLoggedInPersonDetailsHandler(Authentication auth)
	{
		Person personAuthosized = pRepo.findByUsername(auth.getUsername())
				.orElseThrow(() -> new BadCredentialsException("Invalid Username or password"));

		return new ResponseEntity<Person>(personAuthosized, HttpStatus.ACCEPTED);
	}

}
