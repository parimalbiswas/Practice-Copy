package com.parimal.model;

public class EmployeeDTO
{

	String name;
	String address;
	Integer salary;

	public EmployeeDTO(String name, String address, Integer salary)
	{
		super();
		this.name = name;
		this.address = address;
		this.salary = salary;
	}

	public EmployeeDTO()
	{
		super();
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public Integer getSalary()
	{
		return salary;
	}

	public void setSalary(Integer salary)
	{
		this.salary = salary;
	}

}
