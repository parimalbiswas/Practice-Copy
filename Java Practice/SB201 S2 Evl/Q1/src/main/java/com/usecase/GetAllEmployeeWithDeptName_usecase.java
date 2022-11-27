package com.usecase;

import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImpl;
import com.exception.EmployeeException;

public class GetAllEmployeeWithDeptName_usecase
{
	public static void main(String[] args)
	{
		EmployeeDao dao = new EmployeeDaoImpl();
		try
		{
			dao.getAllEmployeeWithDeptName("IT");
		}
		catch (EmployeeException e)
		{

			System.out.println(e.getMessage());
		}
	}
}
