package com.addressbook.model;

import java.util.concurrent.atomic.AtomicInteger;

import com.addressbook.controller.dto.PersonDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {
	private int id;
	private String name;
	private String phoneNumber;
	private String email;
	private Address address;
	
	private static AtomicInteger counter;
	
	static {
		counter = new AtomicInteger();
	}
	
	public Person(PersonDTO personDto) {
		id = counter.incrementAndGet();
		this.name = personDto.getName();
		this.phoneNumber = personDto.getPhoneNumber();
		this.email = personDto.getEmail();
		this.address = personDto.getAddress();
	}
	
}
