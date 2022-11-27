package com.usecase;

import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImpl;
import com.exception.DepartmentException;
import com.model.Department;

public class GetDepartmentDetailsByEmployeeId_usecase
{
	public static void main(String[] args)
	{

		EmployeeDao dao = new EmployeeDaoImpl();
		try
		{
			Department department = dao.getDepartmentDetailsByEmployeeId(6);
			System.out.println(department);
		}
		catch (DepartmentException e)
		{
			System.out.println(e.getMessage());
		}

	}
}
