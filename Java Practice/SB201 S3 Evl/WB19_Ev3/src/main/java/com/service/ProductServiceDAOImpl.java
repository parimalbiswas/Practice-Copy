package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.ProductException;
import com.model.Product;
import com.repository.ProductRepositoryDAOImpl;

@Service
public class ProductServiceDAOImpl implements ProductServiceDAO
{
	@Autowired
	private ProductRepositoryDAOImpl productRepositoryDAOImpl;

	@Override
	public boolean addProduct(Product product)
	{
		boolean yesno = false;

		productRepositoryDAOImpl.insertProductDetails(product);
		yesno = true;

		return yesno;
	}

	@Override
	public List<Product> getAllProducts()
	{
		List<Product> listpProducts = new ArrayList<>();

		try
		{
			listpProducts = productRepositoryDAOImpl.getAllProductDetails();
		}
		catch (ProductException e)
		{
			e.printStackTrace();
		}

		return listpProducts;
	}

	@Override
	public Product getProductById(int productId) throws ProductException
	{
		Product product = null;

		try
		{
			product = productRepositoryDAOImpl.findProduct(productId);

			if (product == null)
			{
				throw new ProductException("Product Not Found By this ID");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new ProductException(e.getMessage());
		}

		return product;
	}

	@Override
	public List<Product> getProductsBetweenPrice(int fromPrice, int toPrice) throws ProductException
	{
		List<Product> products = new ArrayList<>();

		try
		{
			products = productRepositoryDAOImpl.getProductInPriceRange(fromPrice, toPrice);

			if (products.size() == 0)
			{
				throw new ProductException("Mp Product Found....");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new ProductException(e.getMessage());
		}

		return products;
	}

}
