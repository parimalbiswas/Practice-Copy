package com.parimal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parimal.exception.EmployeeException;
import com.parimal.model.Employee;
import com.parimal.model.EmployeeDTO;
import com.parimal.repository.EmployeeRepositoryDAO;

@Service
public class EmployeeServiceDAOImpl implements EmployeeServiceDAO
{
	@Autowired
	private EmployeeRepositoryDAO eRepoDao;

	@Override
	public Employee registerEmployee(Employee emp) throws EmployeeException
	{
		Employee employee = eRepoDao.save(emp);

		if (employee == null)
		{
			throw new EmployeeException("Emp not saved");
		}
		else
		{
			return employee;
		}

	}

	@Override
	public Employee getEmployeeById(Integer empId) throws EmployeeException
	{
		Optional<Employee> opt = eRepoDao.findById(empId);

		if (opt.isPresent())
		{
			Employee employee = opt.get();
			return employee;
		}
		else
		{
			throw new EmployeeException("no emp not found with id " + empId);
		}

	}

	@Override
	public List<Employee> getAllEmployeeDetails() throws EmployeeException
	{
		return eRepoDao.findAll();

	}

	@Override
	public Employee deleteEmployeeById(Integer empId) throws EmployeeException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee loginEmployee(String email, String password) throws EmployeeException
	{
		Employee employee = null;

		List<Employee> emplist = eRepoDao.findAll();

		for (Employee eleemp : emplist)
		{
			if (eleemp.getEmail().equalsIgnoreCase(email))
			{
				if (eleemp.getEmpName().equalsIgnoreCase(password))
				{
					return eleemp;
				}
				else
				{
					throw new EmployeeException("password not found");
				}
			}
			else
			{
				throw new EmployeeException("email not found");
			}
		}

		return employee;
	}

	@Override
	public List<Employee> getEmployeeDetailsByAddress(String address) throws EmployeeException
	{
		List<Employee> list = eRepoDao.findByAddress(address);

		if (list.size() == 0)
		{
			throw new EmployeeException("Not found any employee");
		}

		else
		{
			return list;
		}
	}

	@Override
	public Employee updateEmployee(Employee emp) throws EmployeeException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNameAndAddressOfEmplyeeById(Integer empId) throws EmployeeException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeDTO> getNameAddressSalaryOfAllEmployee() throws EmployeeException
	{

		List<EmployeeDTO> empDTO = eRepoDao.getNameAddressSalaryOfEmployee();

		if (empDTO.size() == 0)
		{
			throw new EmployeeException("Employee Not Found");
		}
		else
		{
			return empDTO;
		}

	}

}
