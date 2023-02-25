package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.ProductException;
import com.masai.exception.UserException;
import com.masai.model.CurrentUserSession;
import com.masai.model.Product;
import com.masai.model.User;
import com.masai.repository.CartDao;
import com.masai.repository.ProductDao;
import com.masai.repository.SessionDao;
import com.masai.repository.UserDao;

@Service
public class UserServiceImpl implements UserService
{

	@Autowired
	private UserDao userDao;
	@Autowired
	private ProductDao productDao;

	@Autowired
	private SessionDao sessionDao;
	@Autowired
	private CartDao cartDao;

	@Override
	public User createUser(User user) throws UserException
	{
		return userDao.save(user);

	}

	@Override
	public List<Product> viewProductByProductName(String productName, String key) throws ProductException
	{

		CurrentUserSession currentUser = sessionDao.findByuuid(key);
		if (currentUser == null)
		{
			throw new ProductException("user not logged in");
		}
		else
		{

			List<Product> products = productDao.findByProductName(productName);

			if (products.size() == 0)
			{
				throw new ProductException("product not found");
			}
			else
			{
				return products;
			}

		}

	}

}
