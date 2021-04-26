package com.addressbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.addressbook.controller.dto.PersonDTO;
import com.addressbook.model.Person;
import com.addressbook.service.IAddressBookService;

@RestController
@RequestMapping("/addressbook")
public class AddressBookRestController {
	
	@Autowired
	private IAddressBookService addressBookService;
	
	@GetMapping
	public ResponseEntity<Person> getContacts(@RequestBody PersonDTO personDto){
		return new ResponseEntity<>(addressBookService.getContact(personDto), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Person> postContact(@RequestBody PersonDTO personDto){
		return new ResponseEntity<> (addressBookService.postContact(personDto), HttpStatus.ACCEPTED);
	}
}
