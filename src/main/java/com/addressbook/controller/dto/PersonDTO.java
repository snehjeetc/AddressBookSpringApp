package com.addressbook.controller.dto;

import com.addressbook.model.Address;

import lombok.Data;

@Data
public class PersonDTO {
	private String name;
	private String phoneNumber;
	private String email;
	private Address address;
}
