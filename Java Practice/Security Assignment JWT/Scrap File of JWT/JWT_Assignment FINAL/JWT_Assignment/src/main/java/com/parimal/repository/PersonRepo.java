package com.parimal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parimal.model.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer>
{
	public Optional<Person> findByUsername(String username);
}
