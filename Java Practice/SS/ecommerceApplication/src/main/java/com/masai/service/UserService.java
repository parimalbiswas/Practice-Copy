package com.masai.service;

import java.util.List;

import com.masai.exception.ProductException;
import com.masai.exception.UserException;
import com.masai.model.Product;
import com.masai.model.User;

public interface UserService
{

	public User createUser(User user) throws UserException;

	public List<Product> viewProductByProductName(String productName, String key) throws ProductException;

//	public Cart addProducttoCart(Product prod,Integer quantity,String key) throws ProductException;

}
