package com.usecase;

import java.util.List;

import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImpl;
import com.exception.EmployeeException;
import com.model.Employee;

public class GetAllEmployeeWithDeptName_usecase
{
	public static void main(String[] args)
	{
		EmployeeDao dao = new EmployeeDaoImpl();
		try
		{
			List<Employee> employees = dao.getAllEmployeeWithDeptName("IT");
			employees.forEach(s -> System.out.println(s.getEmpName() + "======" + s.getDepartment().getDeptName()));
		}
		catch (EmployeeException e)
		{

			System.out.println(e.getMessage());
		}
	}
}
