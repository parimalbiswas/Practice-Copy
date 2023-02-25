package com.masai.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CartException;
import com.masai.exception.UserException;
import com.masai.model.Cart;
import com.masai.model.CurrentUserSession;
import com.masai.model.Orders;
import com.masai.model.Product;
import com.masai.model.User;
import com.masai.repository.OrdersDao;
import com.masai.repository.SessionDao;
import com.masai.repository.UserDao;

@Service
public class OrderServiceImpl implements OrderService
{

	@Autowired
	private OrdersDao oDao;

	@Autowired
	private SessionDao sDao;

	@Autowired
	private UserDao uDao;

	@Autowired
	private UserService userService;

	@Autowired
	private CartService cService;

	@Override
	public Orders orderProductbyUser(Orders obj, String key) throws UserException, CartException
	{

		CurrentUserSession validUser = sDao.findByuuid(key);
		if (validUser == null)
		{
			throw new UserException("user madarchod  hai");

		}

		Integer cartid = validUser.getCartId();
		Cart cart = cService.getCartById(cartid);
		int totalprice = 0;
		int totalquantity = 0;
		int totalbill = 0;

		Map<Product, Integer> orderedProduct = cart.getProducts();
		for (var elem : orderedProduct.entrySet())
		{

			int price = elem.getKey().getPrice();
			totalprice += price;
			int q = (int) elem.getValue();
			totalquantity += q;

			totalbill += totalprice * q;

		}

		obj.setOrderdate(LocalDate.now());
		obj.setOrderStatus("placed");
		obj.setQuantity(totalquantity);
		obj.setTotal(totalbill);
		obj.setOrderedProducts(new HashMap<>(orderedProduct));

		Integer userid = validUser.getUseroradminid();

		System.out.println("===================");

		System.out.println(userid);
		System.out.println("+++++++++++++++++++++++++");
		Optional<User> user = uDao.findById(userid);
		if (user.isEmpty())
		{
			throw new UserException("user harami hai");
		}

		obj.setUser(user.get());

		return oDao.save(obj);

	}

}
