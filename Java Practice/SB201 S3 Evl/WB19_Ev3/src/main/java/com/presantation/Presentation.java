package com.presantation;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.exception.ProductException;
import com.model.Product;
import com.service.ProductServiceDAOImpl;

@Controller
public class Presentation
{
	@Autowired
	private ProductServiceDAOImpl productserviceDAOImpl;

	public void insertProduct()
	{
		try
		{
			Scanner scanner = new Scanner(System.in);

			Product product = new Product(scanner.next(), scanner.nextInt(), scanner.nextInt());
			boolean yesno = productserviceDAOImpl.addProduct(product);

			if (yesno == true)
			{
				System.out.println("Product Addded Succsfully...");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();

		}

	}

	public void printAllProduct()
	{
		try
		{
			List<Product> products = productserviceDAOImpl.getAllProducts();

			products.forEach(s -> System.out.println(s));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void searchProduct()
	{
		try
		{
			Product product = productserviceDAOImpl.getProductById(1);
			System.out.println(product);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void GetProductsWithingPriceRange()
	{
		try
		{
			List<Product> products = productserviceDAOImpl.getProductsBetweenPrice(51, 500);
			products.forEach(s -> System.out.println(s));
		}
		catch (ProductException e)
		{

			e.printStackTrace();
		}
	}

}
