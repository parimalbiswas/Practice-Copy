package com.dao;

import java.util.List;

import com.model.ConractualEmployee;
import com.model.SalariedEmployee;

public interface EmployeeDao
{
	public void saveRecord(List<SalariedEmployee> salaryEmployees, List<ConractualEmployee> conractualEmployees);

	public List<ConractualEmployee> getAllConractualEmployee();

	public List<SalariedEmployee> getAllSalariedEmployee();

}
