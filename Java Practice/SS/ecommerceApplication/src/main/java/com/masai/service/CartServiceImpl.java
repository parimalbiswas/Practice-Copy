package com.masai.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CartException;
import com.masai.exception.ProductException;
import com.masai.model.Cart;
import com.masai.model.Product;
import com.masai.repository.CartDao;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private ProductService prodService;
	
	
	@Override
	public Cart getCartById(Integer cartId) throws CartException {
		
			Cart cart =cartDao.findById(cartId).orElseThrow(()->
				new CartException("cart not found"));
			
			return cart;
		
	}
	@Override
	public Cart addProductToCart(Cart c, Product p, Integer quantity) throws CartException, ProductException {
		if (c == null)
			throw new CartException("No Cart exits for adding this product");
		p = prodService.viewProduct(p.getProductId());
		c.getProducts().put(p, quantity);

		Cart cart = cartDao.save(c);

		return cart;
	}
	

	
	
	@Override
	public Cart removeAllProduct(Cart c) throws CartException {
	 c=	cartDao.findById(c.getCartId()).orElseThrow(()->new CartException("No cart exist for removing the product"));
	
	c.setProducts(new HashMap<>());
	Cart cart = cartDao.save(c);
	return cart;
	}

	@Override
	public Cart removeProductFromCart(Cart c, Product p) throws CartException, ProductException {
	Cart cart = cartDao.findById(c.getCartId()).orElseThrow(()->new CartException("cart not found"));
	p=prodService.viewProduct(p.getProductId());
	if(!cart.getProducts().containsKey(p)) {
		throw new CartException("No similar product found in the cart");
	}else {
		cart.getProducts().remove(p);
		
		return cartDao.save(cart);
	}
	
	}

	@Override
	public Cart updateProductQuantity(Cart c, Product p, Integer quantity) throws CartException, ProductException {
		Cart newcart =cartDao.findById(c.getCartId()).orElseThrow(()->new CartException("Cart not found"));
		
		p=prodService.viewProduct(p.getProductId());
		
		newcart.getProducts().put(p, quantity);
		
		return cartDao.save(newcart);
	}

	@Override
	public Map<Product, Integer> viewAllProduct(Cart c) throws CartException {
		c = cartDao.findById(c.getCartId()).orElseThrow(() -> new CartException("No Cart exits"));

		Map<Product, Integer> producList = c.getProducts();
		return producList;
	}





}
