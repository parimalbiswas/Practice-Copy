package com.masai.service;

import com.masai.exception.AdminException;
import com.masai.exception.LoginException;
import com.masai.exception.ProductException;
import com.masai.model.Admin;
import com.masai.model.Product;

public interface AdminService {
	
	public Admin createAdmin(Admin admin)throws AdminException;

	public Product addProduct(Product p,String key) throws ProductException,LoginException;
}
