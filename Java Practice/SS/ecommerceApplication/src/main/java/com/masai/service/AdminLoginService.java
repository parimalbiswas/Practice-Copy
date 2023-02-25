package com.masai.service;

import com.masai.exception.LoginException;
import com.masai.model.LoginDTO;

public interface AdminLoginService {
	
	public String LogIntoAccount(LoginDTO dto) throws LoginException;
	public String LogOutAccount(String key) throws LoginException;

}
