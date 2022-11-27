package com.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.model.ConractualEmployee;
import com.model.SalariedEmployee;
import com.util.EMUtil;

public class EmployeeDaoImpl implements EmployeeDao
{

	@Override
	public void saveRecord(List<SalariedEmployee> salaryEmployees, List<ConractualEmployee> conractualEmployees)
	{
		EntityManager em1 = EMUtil.provideEntityManager();

		em1.getTransaction().begin();

		for (ConractualEmployee elem1 : conractualEmployees)
		{
			em1.persist(elem1);
		}

		for (SalariedEmployee elem2 : salaryEmployees)
		{
			em1.persist(elem2);
		}
		System.out.println("Done............");

		em1.getTransaction().commit();

		em1.close();

	}

	@Override
	public List<ConractualEmployee> getAllConractualEmployee()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SalariedEmployee> getAllSalariedEmployee()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
