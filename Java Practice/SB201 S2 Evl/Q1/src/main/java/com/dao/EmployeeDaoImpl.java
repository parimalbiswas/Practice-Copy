package com.dao;

import java.util.ArrayList;
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

		try
		{
			Employee employee = em1.find(Employee.class, empId);
			Department department = em1.find(Department.class, deptId);

			if (employee == null)
			{
				throw new EmployeeException("Employee Not Found XX");
			}
			if (department == null)
			{
				throw new DepartmentException("Department Not Found XX");
			}

			if (employee != null && department != null)
			{
				String jpql = "UPDATE Employee  SET department_deptId = :did where empId=:eid";

				Query query = em1.createQuery(jpql);
				query.setParameter("did", deptId);
				query.setParameter("eid", empId);

				em1.getTransaction().begin();

				int x = query.executeUpdate();
				System.out.println(x + " Record Updated Succsfully...");

				em1.getTransaction().commit();
				em1.close();
//				
//
//				em1.persist(employee);

			}
		}
		catch (Exception e)
		{
			throw new EmployeeException(e.getMessage());
		}

	}

	@Override
	public List<Employee> getAllEmployeeWithDeptName(String deptName) throws EmployeeException
	{
		List<Employee> employees = new ArrayList<>();

		EntityManager em1 = EMUtil.provideEntityManager();

		try
		{
			String jpql = "select d.deptId from Department d where d.deptName = :dname";

			Query query = em1.createQuery(jpql);
			query.setParameter("dname", deptName);

			int xid = (int) query.getSingleResult();
			System.out.println("id =========================> " + xid);

			if (xid > 0)
			{
				String jpql2 = "from Employee where department_deptId=:xid";

				Query query2 = em1.createQuery(jpql2);
				query2.setParameter("xid", xid);

				employees = query2.getResultList();
				// employees.forEach(s -> System.out.println(s));

				if (employees.size() == 0)
				{
					throw new EmployeeException("No Employee Found XX");
				}

			}
		}
		catch (Exception e)
		{
			throw new EmployeeException(e.getMessage());
		}

		return employees;
	}

	@Override
	public Department getDepartmentDetailsByEmployeeId(int empId) throws DepartmentException
	{
		Department department = null;

		EntityManager em1 = EMUtil.provideEntityManager();

		try
		{
			Employee employee = em1.find(Employee.class, empId);

			System.out.println(employee.getDepartment().getDeptId());

			String jpql1 = "select d from Department d where d.deptId=:did";

			Query query = em1.createQuery(jpql1);
			query.setParameter("did", employee.getDepartment().getDeptId());

			department = (Department) query.getSingleResult();

			if (department == null)
			{
				throw new DepartmentException("Department Not Found XXXX");
			}

		}
		catch (Exception e)
		{
			throw new DepartmentException(e.getMessage());
		}

		return department;
	}

}
