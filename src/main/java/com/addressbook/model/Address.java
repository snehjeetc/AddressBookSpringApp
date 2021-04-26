package com.addressbook.model;

import lombok.Data;

@Data
public class Address {
	private String houseNo;
	private String local;
	private String city;
	private String state;
	private String country;
	private int zip;
}
