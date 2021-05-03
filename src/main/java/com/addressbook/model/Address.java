package com.addressbook.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {
	private String houseNo;
	private String locality;
	private String city;
	private String state;
	private String country;
	private Integer zip;
}
