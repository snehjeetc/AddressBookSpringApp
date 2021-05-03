package com.addressbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseEntity<Person> getContacts(){
		return new ResponseEntity<>(addressBookService.getContacts(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Person> addContact(@RequestBody PersonDTO personDto){
		return new ResponseEntity<> (addressBookService.addContact(personDto), HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Person> updateContact(@PathVariable int id, @RequestBody PersonDTO personDTO){
		return new ResponseEntity<>(addressBookService.updateContact(id, personDTO), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping
	public ResponseEntity<Person> deleteContact(@RequestParam String name){
		return new ResponseEntity<>(addressBookService.deleteContact(name), HttpStatus.OK);
	}
}
