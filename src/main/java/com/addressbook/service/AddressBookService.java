package com.addressbook.service;

import java.util.List;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.addressbook.dto.PersonDTO;
import com.addressbook.exception.AddressBookException;
import com.addressbook.exception.AddressBookException.EXCEPTION_TYPE;
import com.addressbook.model.Address;
import com.addressbook.model.Person;
import com.addressbook.repository.IAddressRepository;
import com.addressbook.repository.IPersonRepository;

@Service
public class AddressBookService implements IAddressBookService{

	@Autowired
	private IPersonRepository contactRepo;
	
	@Autowired
	private IAddressRepository addressRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<Person> getContacts() {
		return contactRepo.findAll();
	}

	@Override
	public Person getContact(String name) {
		Person person =  this.contactRepo.findByName(name)
								  .stream()
								  .findFirst()
								  .orElseThrow(() -> new AddressBookException(
										  			name + " doesn't exist", 
										  			EXCEPTION_TYPE.CONTACT_NOT_FOUND));
		return person;
	}

	@Override
	public Person addContact(PersonDTO personDto) {
		Person person = modelMapper.map(personDto, Person.class);
		return this.contactRepo.save(person);
	}

	@Override 
	public Person updateContact(int id, PersonDTO personDto) {
		Person person = this.contactRepo.findById(id).orElseThrow(() -> new AddressBookException(
																	 id + " doesn't exist", 
																	 EXCEPTION_TYPE.CONTACT_NOT_FOUND));
		modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
		Address address = modelMapper.map(person.getAddress(), Address.class);
		modelMapper.map(personDto.getAddress(), address);
		address = this.addressRepo.save(address);
		modelMapper.map(personDto, person);
		person.setAddress(address);
		return this.contactRepo.save(person);
	}
	
	@Override
	public Person deleteContact(String name) {
		Person person = this.getContact(name);
		this.contactRepo.deleteById(person.getId());
		return person;
	}
}
