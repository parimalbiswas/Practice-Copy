package com.usecase;

import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImpl;
import com.model.Address;
import com.model.Employee;

public class AddEmployee_usecase
{
	public static void main(String[] args)
	{
		Address address1 = new Address("kanpur", "UP", "208009");

		Employee employee1 = new Employee();
		employee1.setEmpName("Ratan");
		employee1.setSalary(56000);
		employee1.setAddress(address1);

		Address address2 = new Address("Kolkata", "WB", "711107");

		Employee employee2 = new Employee();
		employee2.setEmpName("Gupta");
		employee2.setSalary(23000);
		employee2.setAddress(address2);

		// employee.setDepartment(null);

		EmployeeDao dao = new EmployeeDaoImpl();
		dao.addEmployee(employee1);
		dao.addEmployee(employee2);
	}
}
