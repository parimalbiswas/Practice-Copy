package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.exception.DepartmentException;
import com.exception.EmployeeException;
import com.model.Department;
import com.model.Employee;
import com.util.EMUtil;

public class EmployeeDaoImpl implements EmployeeDao
{

	@Override
	public void addDepartment(Department dept)
	{
		EntityManager em1 = EMUtil.provideEntityManager();

		em1.getTransaction().begin();

		em1.persist(dept);
		System.out.println("Done");

		em1.getTransaction().commit();

		em1.close();

	}

	@Override
	public void addEmployee(Employee emp)
	{
		EntityManager em1 = EMUtil.provideEntityManager();

		em1.getTransaction().begin();

		em1.persist(emp);
		System.out.println("Done");

		em1.getTransaction().commit();

		em1.close();

	}

	@Override
	public void registerEmployeeTODepartment(int empId, int deptId) throws EmployeeException, DepartmentException
	{
		EntityManager em1 = EMUtil.provideEntityManager();

		Employee employee = em1.find(Employee.class, empId);
		Department department = em1.find(Department.class, deptId);

		if (employee != null && department != null)
		{
			String jpql = "select s";

			Query query = em1.createQuery(jpql);
		}

	}

	@Override
	public List<Employee> getAllEmployeeWithDeptName(String deptName) throws EmployeeException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department getDepartmentDetailsByEmployeeId(int empId) throws DepartmentException
	{
		// TODO Auto-generated method stub
		return null;
	}

}
