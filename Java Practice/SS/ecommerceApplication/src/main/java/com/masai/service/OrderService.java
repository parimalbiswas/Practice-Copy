package com.masai.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.exception.CartException;
import com.masai.exception.UserException;
import com.masai.model.Orders;

public interface OrderService {

   public Orders orderProductbyUser(Orders obj,String key)throws UserException,CartException;

	
	
}
