package com.addressbook.service;

import com.addressbook.controller.dto.PersonDTO;
import com.addressbook.model.Person;

public interface IAddressBookService {
	Person getContacts();
	Person addContact(PersonDTO personDto);
	Person updateContact(int id, PersonDTO personDto);
	Person deleteContact(String name);
}
