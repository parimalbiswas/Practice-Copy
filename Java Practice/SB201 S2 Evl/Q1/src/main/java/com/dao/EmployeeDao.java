package com.dao;

import java.util.List;

import com.exception.DepartmentException;
import com.exception.EmployeeException;
import com.model.Department;
import com.model.Employee;

public interface EmployeeDao
{
	public void addDepartment(Department dept);

	public void addEmployee(Employee emp);

	public void registerEmployeeTODepartment(int empId, int deptId) throws EmployeeException, DepartmentException;

	List<Employee> getAllEmployeeWithDeptName(String deptName) throws EmployeeException;

	Department getDepartmentDetailsByEmployeeId(int empId) throws DepartmentException;

}
