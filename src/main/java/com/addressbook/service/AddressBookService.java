package com.addressbook.service;

import org.springframework.stereotype.Service;

import com.addressbook.controller.dto.PersonDTO;
import com.addressbook.model.Address;
import com.addressbook.model.Person;

@Service
public class AddressBookService implements IAddressBookService{
	
	@Override
	public Person getContacts() {
		return new Person(
				"Random Guy",
				"randomEmail@gmail.com",
				"9922345688",
				new Address(
						"23A",
						"Church Street",
						"Lucknow",
						"Uttar Pradesh",
						"India",
						226012)
				);
				
	}

	@Override
	public Person addContact(PersonDTO personDto) {
		Person person = new Person(personDto);
		person.generateId();
		return person;
	}
	
	@Override 
	public Person updateContact(int id, PersonDTO personDto) {
		Person person = new Person(personDto);
		person.setId(id);
		return person;
	}
	
	
	@Override
	public Person deleteContact(String name) {
		return new Person(
				name,
				"randomEmail@gmail.com",
				"9922345688",
				new Address(
						"23A",
						"Church Street",
						"Lucknow",
						"Uttar Pradesh",
						"India",
						226012)
				);
	}
}
