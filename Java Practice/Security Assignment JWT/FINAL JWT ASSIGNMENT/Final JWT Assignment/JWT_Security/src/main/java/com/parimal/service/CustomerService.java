package com.parimal.service;

import java.util.List;

import com.parimal.model.Customer;

public interface CustomerService
{

	public Customer registerCustomer(Customer customer);

	public List<List<String>> accessStaticData();

}
