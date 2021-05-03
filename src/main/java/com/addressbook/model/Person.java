package com.addressbook.model;

import java.util.concurrent.atomic.AtomicInteger;

import com.addressbook.controller.dto.PersonDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Person {
	private Integer id;
	private String name;
	private String phoneNumber;
	private String email;
	private Address address;
	
	private static AtomicInteger counter;
	
	static {
		counter = new AtomicInteger();
	}
	
	public void generateId() {
		this.id = counter.incrementAndGet();
	}
	
	public Person(PersonDTO personDto) {
		this.name = personDto.getName();
		this.phoneNumber = personDto.getPhoneNumber();
		this.email = personDto.getEmail();
		this.address = personDto.getAddress();
	}
	
	public Person(String name, String phoneNumber, String email, Address address) {
		this.id = counter.incrementAndGet();
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
}
