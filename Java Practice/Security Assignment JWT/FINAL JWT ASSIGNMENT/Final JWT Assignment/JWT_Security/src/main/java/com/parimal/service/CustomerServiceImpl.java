package com.parimal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parimal.exception.CustomerException;
import com.parimal.model.Customer;
import com.parimal.model.DataOfData;
import com.parimal.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService
{

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer registerCustomer(Customer customer) throws CustomerException
	{
		return customerRepository.save(customer);
	}

	@Override
	public List<List<String>> accessStaticData()
	{
		return DataOfData.getData();
	}

}
