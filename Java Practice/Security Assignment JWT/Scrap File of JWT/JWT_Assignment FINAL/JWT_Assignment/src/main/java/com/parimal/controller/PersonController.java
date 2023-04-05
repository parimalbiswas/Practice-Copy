package com.parimal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.parimal.model.Person;
import com.parimal.service.PersonService;

@RestController
public class PersonController
{
	@Autowired
	private PersonService personService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/hi")
	public String testHandler()
	{
		return "Welcome Parimal";
	}

	@PostMapping("/signup")
	public ResponseEntity<Person> registerPersonHandler(@RequestBody Person person)
	{
//		person.setPassword(passwordEncoder.encode(person.getPassword()));
//		
//		person.setPassword(passwordEncoder.encode(person.getPassword()));

		Person registerPerson = personService.registerPerson(person);

		return new ResponseEntity<>(registerPerson, HttpStatus.ACCEPTED);
	}

	@GetMapping("/staticdata")
	public ResponseEntity<List<List<String>>> staticData()
	{
		return new ResponseEntity<>(personService.accessStaticData(), HttpStatus.OK);
	}

}
