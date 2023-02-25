package com.masai.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {


	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartId;
	
	@ElementCollection
//	@JsonIgnore
	private Map<Product, Integer> Products =new HashMap<>();

//	public Integer getCartId() {
//		return cartId;
//	}
//
//	public void setCartId(Integer cartId) {
//		this.cartId = cartId;
//	}
//
//	public Map<Product, Integer> getProducts() {
//		return Products;
//	}
//
//	@Bean(value = "products")
//	public void setProducts(Map<Product, Integer> products) {
//		Products = products;
//	}
//
//	@Override
//	public String toString() {
//		return "Cart [cartId=" + cartId + "]";
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(Products, cartId);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Cart other = (Cart) obj;
//		return Objects.equals(Products, other.Products) && Objects.equals(cartId, other.cartId);
//	}
//	
	

	
	
	
	
	
}
