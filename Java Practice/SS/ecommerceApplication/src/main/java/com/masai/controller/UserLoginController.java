package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.LoginException;
import com.masai.model.LoginDTO;
import com.masai.service.UserLoginService;

@RestController
@RequestMapping("/user")
public class UserLoginController
{
	@Autowired
	private UserLoginService uLogin;

	@PostMapping("/login")
	public ResponseEntity<String> userLogin(@RequestBody LoginDTO dto) throws LoginException
	{
		String res = uLogin.LogIntoAccount(dto);

		return new ResponseEntity<String>(res, HttpStatus.OK);
	}

	///////////////////////////////////////////////////////

	@PostMapping("/logout")
	public ResponseEntity<String> adminLogout(@RequestBody String key) throws LoginException
	{
		String res = uLogin.LogOutAccount(key);
		return new ResponseEntity<String>(res, HttpStatus.OK);
	}

	//////////////////////////////////////////////////////

}
