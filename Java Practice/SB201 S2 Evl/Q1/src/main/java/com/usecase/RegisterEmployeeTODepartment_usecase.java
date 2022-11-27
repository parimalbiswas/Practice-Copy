package com.usecase;

import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImpl;
import com.exception.DepartmentException;
import com.exception.EmployeeException;

public class RegisterEmployeeTODepartment_usecase
{
	public static void main(String[] args)
	{

		EmployeeDao dao = new EmployeeDaoImpl();
		try
		{
			dao.registerEmployeeTODepartment(6, 3);
		}
		catch (EmployeeException em)
		{
			System.out.println(em.getMessage());
		}
		catch (DepartmentException ed)
		{
			System.out.println(ed.getMessage());
		}
	}
}
