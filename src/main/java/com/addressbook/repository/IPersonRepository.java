package com.addressbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.addressbook.model.Person;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Integer> {
	@Query(value = "SELECT * FROM contact_table where name = :name LIMIT 1", nativeQuery = true)
	List<Person> findByName(String name);
}
