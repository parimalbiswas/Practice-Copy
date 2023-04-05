package com.parimal.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.parimal.model.Customer;
import com.parimal.service.CustomerService;

@RestController
public class CustomerController
{

	@Autowired
	private CustomerService customerService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private Map<Integer, List<String>> maps;

	@PostMapping("/customers")
	public ResponseEntity<Customer> saveCustomerHandler(@RequestBody Customer customer)
	{

		customer.setPassword(passwordEncoder.encode(customer.getPassword()));

		Customer registeredCustomer = customerService.registerCustomer(customer);

		return new ResponseEntity<>(registeredCustomer, HttpStatus.ACCEPTED);
	}

	@GetMapping("/hello")
	public String testHandler()
	{
		return "Welcome Parimal";
	}

	@GetMapping("/data")
	public ResponseEntity<List<List<String>>> accessStaticDataHandler()
	{

		List<List<String>> listData = customerService.accessStaticData();

		return new ResponseEntity<>(listData, HttpStatus.OK);
	}

	@GetMapping("/datamap")
	public ResponseEntity<Map<Integer, List<String>>> accessStaticMapDataHandler()
	{

		return new ResponseEntity<>(maps, HttpStatus.OK);
	}

}
