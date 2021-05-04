package com.addressbook.controller;

import javax.validation.Valid;

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

import com.addressbook.dto.PersonDTO;
import com.addressbook.dto.ResponseDTO;
import com.addressbook.service.IAddressBookService;

@RestController
@RequestMapping("/addressbook")
public class AddressBookRestController {
	
	@Autowired
	private IAddressBookService addressBookService;
	
	@GetMapping
	public ResponseEntity<ResponseDTO> getContacts(){
		return new ResponseEntity<>(new ResponseDTO(
									addressBookService.getContacts(),
									"Fetched contacts successfully"),
									HttpStatus.OK);
	}
	
	@GetMapping("/contact")
	public ResponseEntity<ResponseDTO> getContact(@RequestParam String name){
		return new ResponseEntity<>(new ResponseDTO(
									addressBookService.getContact(name), 
									"Fetched " + name + " successfully"),
									HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ResponseDTO> addContact(@Valid @RequestBody PersonDTO personDto){
		return new ResponseEntity<> (new ResponseDTO(
									addressBookService.addContact(personDto),
									"Added Contact successfully"),
									HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ResponseDTO> updateContact(@PathVariable int id,@Valid @RequestBody PersonDTO personDTO){
		return new ResponseEntity<>(new ResponseDTO(
									addressBookService.updateContact(id, personDTO),
									"Updated contact successfully"),
									HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseDTO> deleteContact(@RequestParam String name){
		return new ResponseEntity<>(new ResponseDTO(
									addressBookService.deleteContact(name), 
									"Deleted contact successfully"),
									HttpStatus.OK);
	}
	
}
