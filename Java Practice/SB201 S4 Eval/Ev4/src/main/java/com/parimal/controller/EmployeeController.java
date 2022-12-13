package com.parimal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.parimal.exception.EmployeeException;
import com.parimal.model.Employee;
import com.parimal.model.EmployeeDTO;
import com.parimal.service.EmployeeServiceDAOImpl;

import jakarta.validation.Valid;

@RestController
public class EmployeeController
{
	@Autowired
	private EmployeeServiceDAOImpl eServiceDao;

	@PostMapping("/register")
	public ResponseEntity<Employee> registerEmployee(@Valid @RequestBody Employee employee) throws EmployeeException
	{

		Employee registeremployee = eServiceDao.registerEmployee(employee);

		return new ResponseEntity<Employee>(registeremployee, HttpStatus.ACCEPTED);

	}

	@GetMapping("/getalldto")
	public ResponseEntity<List<EmployeeDTO>> getNameAddressSalaryOfAllEmployeeHandler() throws EmployeeException
	{

		List<EmployeeDTO> dto = eServiceDao.getNameAddressSalaryOfAllEmployee();

		return new ResponseEntity<List<EmployeeDTO>>(dto, HttpStatus.ACCEPTED);

	}

	@GetMapping("/employeebyaddress/{add}")
	public ResponseEntity<List<Employee>> getEmployeeDetailsByAddressHandler(@PathVariable("add") String address)
			throws EmployeeException
	{

		List<Employee> emplist = eServiceDao.getEmployeeDetailsByAddress(address);

		return new ResponseEntity<List<Employee>>(emplist, HttpStatus.ACCEPTED);

	}

//	@PostMapping("/login")
//	public ResponseEntity<Employee> loginEmployee(@ String email, @RequestBody String password)
//			throws EmployeeException
//	{
//
//		Employee emplist = eServiceDao.loginEmployee(email, password);
//
//		return new ResponseEntity<Employee>(emplist, HttpStatus.ACCEPTED);
//
//	}

}
