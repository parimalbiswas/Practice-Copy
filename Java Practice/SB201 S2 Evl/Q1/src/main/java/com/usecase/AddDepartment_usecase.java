package com.usecase;

import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImpl;
import com.model.Department;

public class AddDepartment_usecase
{
	public static void main(String[] args)
	{

		Department department1 = new Department();
		department1.setDeptName("Sales");
		department1.setLocation("Goa");

		Department department2 = new Department();
		department2.setDeptName("HR");
		department2.setLocation("Chennai");

		Department department3 = new Department();
		department3.setDeptName("IT");
		department3.setLocation("Pune");

		EmployeeDao dao = new EmployeeDaoImpl();
		dao.addDepartment(department1);
		dao.addDepartment(department2);
		dao.addDepartment(department3);
	}
}
