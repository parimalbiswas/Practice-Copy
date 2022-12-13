package com.parimal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.parimal.exception.EmployeeException;
import com.parimal.model.Employee;
import com.parimal.model.EmployeeDTO;

@Repository
public interface EmployeeRepositoryDAO extends JpaRepository<Employee, Integer>
{

	@Query("select new com.parimal.model.EmployeeDTO(s.empName,s.address,s.salary) from Employee s")
	public List<EmployeeDTO> getNameAddressSalaryOfEmployee() throws EmployeeException;

	// public String findByEmpNameAndAddressOfEmplyeeById(Integer empId) throws
	// EmployeeException;

	public List<Employee> findByAddress(String address) throws EmployeeException;

}
