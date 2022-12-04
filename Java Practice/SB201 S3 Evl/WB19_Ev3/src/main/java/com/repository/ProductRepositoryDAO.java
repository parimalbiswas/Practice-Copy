package com.repository;

import java.util.List;

import com.exception.ProductException;
import com.model.Product;

public interface ProductRepositoryDAO
{

	public boolean insertProductDetails(Product product);

	public List<Product> getAllProductDetails() throws ProductException;

	public Product findProduct(int productId) throws ProductException;

	public List<Product> getProductInPriceRange(int fromPrice, int toPrice) throws ProductException;
}
