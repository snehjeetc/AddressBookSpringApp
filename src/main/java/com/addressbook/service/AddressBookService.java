package com.addressbook.service;

import java.util.List;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.addressbook.dto.PersonDTO;
import com.addressbook.model.Person;

@Service
public class AddressBookService implements IAddressBookService{
	
	@Autowired
	private List<Person> contactList;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<Person> getContacts() {
		return this.contactList;
	}
	
	@Override
	public Person getContact(String name) {
		return this.contactList.stream()
							   .filter(person -> person.getName().equals(name))
							   .findFirst()
							   .get();
	}

	@Override
	public Person addContact(PersonDTO personDto) {
		Person person = new Person(personDto);
		person.generateId();
		this.contactList.add(person);
		return person;
	}
	
	@Override 
	public Person updateContact(int id, PersonDTO personDto) {
		Person person = this.contactList.stream()
										.filter(p -> p.getId() == id)
										.findFirst()
										.get();
		modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
		modelMapper.map(personDto, person);
		return person;
	}
	
	
	
	@Override
	public Person deleteContact(String name) {
		Person person = this.contactList.stream()
										.filter(p -> p.getName().equals(name))
										.findFirst()
										.get();
		this.contactList.remove(person);
		return person;
	}
}
