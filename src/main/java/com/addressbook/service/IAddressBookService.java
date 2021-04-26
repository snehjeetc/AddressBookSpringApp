package com.addressbook.service;

import com.addressbook.controller.dto.PersonDTO;
import com.addressbook.model.Person;

public interface IAddressBookService {
	Person getContact(PersonDTO personDto);
	Person postContact(PersonDTO personDto);
}
