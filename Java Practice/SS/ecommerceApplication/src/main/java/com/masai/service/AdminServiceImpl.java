package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.AdminException;
import com.masai.exception.LoginException;
import com.masai.exception.ProductException;
import com.masai.model.Admin;
import com.masai.model.Category;
import com.masai.model.CurrentUserSession;
import com.masai.model.Product;
import com.masai.repository.AdminDao;
import com.masai.repository.CategoryDao;
import com.masai.repository.ProductDao;
import com.masai.repository.SessionDao;

@Service
public class AdminServiceImpl implements AdminService
{
	@Autowired
	private ProductDao pDao;
	@Autowired
	private AdminDao aDao;
	@Autowired
	private SessionDao sDao;
	@Autowired
	private CategoryDao cDao;

	@Override
	public Product addProduct(Product p, String key) throws ProductException, LoginException
	{
		CurrentUserSession admin = sDao.findByuuid(key);
		if (admin == null)
		{
			throw new LoginException("session Invalid");
		}

		if (admin.getKonhai().equalsIgnoreCase("admin"))
		{
			Category cat = new Category();
			cat.setCategoryName(p.getCategoryName());
//		cat.setCategoryName(p.getCategory().getCategoryName());
			p.setCategory(cat);

			cat.getProducts().add(p);
			cDao.save(cat);
			return pDao.save(p);
		}
		else
		{
			throw new LoginException("u r not valid admin");
		}

	}

	@Override
	public Admin createAdmin(Admin admin) throws AdminException
	{

		return aDao.save(admin);

	}

}
