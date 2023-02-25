package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.AdminException;
import com.masai.exception.LoginException;
import com.masai.exception.ProductException;
import com.masai.model.Admin;
import com.masai.model.Product;
import com.masai.service.AdminService;

@RestController
@RequestMapping("/admincontrol")
public class AdminController
{
	@Autowired
	private AdminService adminService;

	@PostMapping("/addProduct")
	public ResponseEntity<Product> addProductHandler(@RequestBody Product prod, @RequestParam String key)
			throws ProductException, LoginException
	{

		Product p = adminService.addProduct(prod, key);

		return new ResponseEntity<Product>(p, HttpStatus.OK);

	}

	@PostMapping("/createadmin")
	public ResponseEntity<Admin> createAdminHandler(@RequestBody Admin admin) throws AdminException
	{

		Admin ad = adminService.createAdmin(admin);

		return new ResponseEntity<Admin>(ad, HttpStatus.CREATED);
	}
}
