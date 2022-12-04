package com.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.exception.ProductException;
import com.model.Product;
import com.util.EMUtil;

@Repository
public class ProductRepositoryDAOImpl implements ProductRepositoryDAO
{

	@Override
	public boolean insertProductDetails(Product product)
	{
		boolean truefalse = false;

		EntityManager em1 = EMUtil.provideEntityManager();

		em1.getTransaction().begin();

		em1.persist(product);
		truefalse = true;

		em1.getTransaction().commit();

		em1.clear();
		return false;
	}

	@Override
	public List<Product> getAllProductDetails() throws ProductException
	{
		List<Product> productslist1 = new ArrayList<>();
		try
		{
			EntityManager em1 = EMUtil.provideEntityManager();
			Query query = em1.createQuery("from Product");
			productslist1 = query.getResultList();

			if (productslist1.size() == 0)
			{
				throw new ProductException("No Product Found.....");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new ProductException(e.getMessage());
		}

		return productslist1;
	}

	@Override
	public Product findProduct(int productId) throws ProductException
	{
		Product product = null;

		try
		{
			EntityManager em1 = EMUtil.provideEntityManager();
			product = em1.find(Product.class, productId);

			if (product == null)
			{
				throw new ProductException("Not Found.....");
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
	public List<Product> getProductInPriceRange(int fromPrice, int toPrice) throws ProductException
	{
		List<Product> list = new ArrayList<>();

		try
		{
			EntityManager em1 = EMUtil.provideEntityManager();
			Query query = em1.createQuery("select p from Product p where price BETWEEN ?1 AND ?2");
			query.setParameter(1, fromPrice);
			query.setParameter(2, toPrice);

			list = query.getResultList();

			if (list.size() == 0)
			{
				throw new ProductException("No Product Found in Such Range.....");
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new ProductException(e.getMessage());
		}

		return list;
	}

}
