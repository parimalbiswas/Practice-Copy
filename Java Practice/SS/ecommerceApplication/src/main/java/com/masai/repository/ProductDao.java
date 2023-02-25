package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{
	
	public  List<Product> findByProductName(String productName);

}
