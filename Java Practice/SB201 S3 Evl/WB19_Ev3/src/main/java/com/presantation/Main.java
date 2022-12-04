package com.presantation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.util.AppConfig;

public class Main
{
	public static void main(String[] args)
	{
		ApplicationContext ctx1 = new AnnotationConfigApplicationContext(AppConfig.class);

		Presentation presentation = ctx1.getBean("presentation", Presentation.class);

		System.out.println("======================================");
		presentation.insertProduct();
		System.out.println("======================================");
		presentation.printAllProduct();
		System.out.println("======================================");
		presentation.searchProduct();
		System.out.println("======================================");
		presentation.GetProductsWithingPriceRange();
		System.out.println("======================================");

	}

}
