package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CartException;
import com.masai.exception.LoginException;
import com.masai.exception.ProductException;
import com.masai.exception.UserException;
import com.masai.model.Cart;
import com.masai.model.CurrentUserSession;
import com.masai.model.Orders;
import com.masai.model.Product;
import com.masai.model.User;
import com.masai.repository.SessionDao;
import com.masai.service.CartService;
import com.masai.service.OrderService;
import com.masai.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController
{
	@Autowired
	private UserService userService;
	@Autowired
	private CartService cSer;

//	@Autowired
//	private UserLoginService loginService;

	@Autowired
	private SessionDao sessionDao;

	@Autowired
	private OrderService orService;

	@PostMapping("/createUser")
	public ResponseEntity<User> createUserHandler(@RequestBody User user) throws UserException
	{

		System.out.println("+++++++++++++++++++");
		User usercreated = userService.createUser(user);
		System.out.println("=================");
		return new ResponseEntity<User>(usercreated, HttpStatus.CREATED);
	}

	@GetMapping("/viewProductByName")
	public ResponseEntity<List<Product>> viewProductByNameHandler(@RequestParam String productName,
			@RequestParam String key) throws ProductException
	{
		List<Product> products = userService.viewProductByProductName(productName, key);
		return new ResponseEntity<List<Product>>(products, HttpStatus.ACCEPTED);
	}

	@PostMapping("/addproducttocart")
	public ResponseEntity<Cart> addProductInCart(@RequestBody Product p, @RequestParam Integer quantity,
			@RequestParam String key) throws ProductException, LoginException, CartException
	{

		CurrentUserSession loggedInUser = sessionDao.findByuuid(key);

		if (loggedInUser == null)
		{
			throw new LoginException("user not logged In");
		}
		Integer cartId = loggedInUser.getCartId();
		Cart cart = cSer.getCartById(cartId);
		Cart cc = cSer.addProductToCart(cart, p, quantity);

		return new ResponseEntity<Cart>(cc, HttpStatus.OK);
	}

	@PostMapping("/createOrder")
	public ResponseEntity<Orders> createOrder(@RequestParam String key)
			throws ProductException, LoginException, CartException, UserException
	{

		CurrentUserSession loggedInUser = sessionDao.findByuuid(key);

		if (loggedInUser == null)
		{
			throw new LoginException("user not logged In");

		}

		Orders obj = new Orders();
		Orders cc = orService.orderProductbyUser(obj, key);

		return new ResponseEntity<Orders>(cc, HttpStatus.OK);
	}

}
