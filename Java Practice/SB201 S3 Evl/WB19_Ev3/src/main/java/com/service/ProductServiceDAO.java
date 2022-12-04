package com.service;

import java.util.List;

import com.exception.ProductException;
import com.model.Product;

public interface ProductServiceDAO
{
	public boolean addProduct(Product product);

	public List<Product> getAllProducts();

	public Product getProductById(int productId) throws ProductException;

	public List<Product> getProductsBetweenPrice(int fromPrice, int toPrice) throws ProductException;
}
