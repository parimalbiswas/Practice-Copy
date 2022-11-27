package com.usecase;

import java.util.ArrayList;
import java.util.List;

import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImpl;
import com.model.ConractualEmployee;
import com.model.SalariedEmployee;

public class SaveRecord_usecase
{

	public static void main(String[] args)
	{

		SalariedEmployee salariedEmployee1 = new SalariedEmployee();
		salariedEmployee1.setEmpName("Jonny");
		salariedEmployee1.setEmail("jonno@jonno.com");
		salariedEmployee1.setSalary(50000);

		SalariedEmployee salariedEmployee2 = new SalariedEmployee();
		salariedEmployee2.setEmpName("Nino");
		salariedEmployee2.setEmail("Nono@aaa.com");
		salariedEmployee2.setSalary(2000);

		SalariedEmployee salariedEmployee3 = new SalariedEmployee();
		salariedEmployee3.setEmpName("kaka");
		salariedEmployee3.setEmail("kaka@ggg.com");
		salariedEmployee3.setSalary(7000);

		List<SalariedEmployee> slist = new ArrayList<>();
		slist.add(salariedEmployee1);
		slist.add(salariedEmployee2);
		slist.add(salariedEmployee3);

		ConractualEmployee conractualEmployee1 = new ConractualEmployee();
		conractualEmployee1.setEmpName("Raju");
		conractualEmployee1.setCostofperday(100);
		conractualEmployee1.setNoOfWorkingDays(30);
		conractualEmployee1.setMobileNumber("7899424545");

		ConractualEmployee conractualEmployee2 = new ConractualEmployee();
		conractualEmployee2.setEmpName("Mama");
		conractualEmployee2.setCostofperday(150);
		conractualEmployee2.setNoOfWorkingDays(20);
		conractualEmployee2.setMobileNumber("454545454");

		ConractualEmployee conractualEmployee3 = new ConractualEmployee();
		conractualEmployee3.setEmpName("Raju");
		conractualEmployee3.setCostofperday(100);
		conractualEmployee3.setNoOfWorkingDays(30);
		conractualEmployee3.setMobileNumber("7899424545");

		List<ConractualEmployee> clist = new ArrayList<>();
		clist.add(conractualEmployee1);
		clist.add(conractualEmployee2);
		clist.add(conractualEmployee3);

		EmployeeDao dao = new EmployeeDaoImpl();
		dao.saveRecord(slist, clist);
	}
}
