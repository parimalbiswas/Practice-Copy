package com.parimal.service;

import java.util.List;

import com.parimal.exception.EmployeeException;
import com.parimal.model.Employee;
import com.parimal.model.EmployeeDTO;

public interface EmployeeServiceDAO
{

	public Employee registerEmployee(Employee emp) throws EmployeeException;

	public Employee getEmployeeById(Integer empId) throws EmployeeException;

	public List<Employee> getAllEmployeeDetails() throws EmployeeException;

	public Employee deleteEmployeeById(Integer empId) throws EmployeeException;

	public Employee loginEmployee(String email, String password) throws EmployeeException;

	public List<Employee> getEmployeeDetailsByAddress(String address) throws EmployeeException;

	public Employee updateEmployee(Employee emp) throws EmployeeException;

	public String getNameAndAddressOfEmplyeeById(Integer empId) throws EmployeeException;

	public List<EmployeeDTO> getNameAddressSalaryOfAllEmployee() throws EmployeeException;
}
