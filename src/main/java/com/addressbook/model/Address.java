package com.addressbook.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {
	private String houseNo;
	private String local;
	private String city;
	private String state;
	private String country;
	private Integer zip;
}
