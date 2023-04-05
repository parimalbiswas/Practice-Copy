package com.parimal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parimal.model.DataOfData;
import com.parimal.model.Person;
import com.parimal.repository.PersonRepo;

@Service
public class PersonServiceImpl implements PersonService
{
	@Autowired
	private PersonRepo pRepo;

	@Override
	public Person registerPerson(Person person)
	{
		return pRepo.save(person);
	}

	@Override
	public List<List<String>> accessStaticData()
	{
		DataOfData data = new DataOfData();

		return data.getDataList1();

	}

}
