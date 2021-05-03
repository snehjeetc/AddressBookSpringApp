package com.addressbook.service;

import java.util.List;

import com.addressbook.dto.PersonDTO;
import com.addressbook.model.Person;

public interface IAddressBookService {
	List<Person> getContacts();
	Person getContact(String name);
	Person addContact(PersonDTO personDto);
	Person updateContact(int id, PersonDTO personDto);
	Person deleteContact(String name);
}
