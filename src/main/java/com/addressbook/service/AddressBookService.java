package com.addressbook.service;

import org.springframework.stereotype.Service;

import com.addressbook.controller.dto.PersonDTO;
import com.addressbook.model.Person;

@Service
public class AddressBookService implements IAddressBookService{

	@Override
	public Person getContact(PersonDTO personDto) {
		return new Person(personDto);
	}

	@Override
	public Person postContact(PersonDTO personDto) {
		return new Person(personDto);
	}
	
}
