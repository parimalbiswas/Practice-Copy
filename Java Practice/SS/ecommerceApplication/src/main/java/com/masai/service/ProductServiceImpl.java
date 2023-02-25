package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.ProductException;
import com.masai.model.Category;
import com.masai.model.Product;
import com.masai.repository.CategoryDao;
import com.masai.repository.ProductDao;

@Service
public class ProductServiceImpl implements ProductService
{

	@Autowired
	private ProductDao prodDao;

	@Autowired
	private CategoryDao catDao;

	@Override
	public List<Product> viewAllProducts() throws ProductException
	{
		List<Product> products = prodDao.findAll();
		if (products.size() == 0)
		{
			throw new ProductException("No product found");
		}
		else
		{
			return products;
		}
	}

	@Override
	public Product viewProduct(Integer id) throws ProductException
	{
		Optional<Product> opt = prodDao.findById(id);
		if (opt.isPresent())
		{
			Product viewProduct = opt.get();
			return viewProduct;
		}
		else
		{
			throw new ProductException("Product with id not found");
		}
	}

	@Override
	public List<Product> viewProductByCategory(String cname) throws ProductException
	{
		Category category = catDao.findByCategoryName(cname);
		if (category == null)
		{
			throw new ProductException("no product found in category " + cname);

		}
		List<Product> products = category.getProducts();

		if (products.isEmpty())
		{
			throw new ProductException("No prod found");

		}
		else
		{
			return products;
		}
	}

	@Override
	public List<Product> viewProductByProductName(String productName) throws ProductException
	{
		List<Product> products = prodDao.findByProductName(productName);
		if (products.isEmpty())
		{
			throw new ProductException("No product found");
		}
		else
		{

			return products;
		}
	}

}
