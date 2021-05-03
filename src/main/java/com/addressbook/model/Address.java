package com.addressbook.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {
	@NotNull
	@Pattern(regexp = "^[a-zA-Z0-9-/]+",message = "Invalid House number")
	private String houseNo;
	
	@NotNull
	@Pattern(regexp = "[A-Z][a-z]{2,}(\s[A-Z][a-z]*)*", message = "Invalid locality")
	private String locality;
	
	@NotNull
	@Pattern(regexp = "[A-Z][a-z]{2,}(\s[A-Z][a-z]*)*", message = "Invalid City")
	private String city;

	@NotNull
	@Pattern(regexp = "[A-Z][a-z]{2,}(\s[A-Z][a-z]*)*", message = "Invalid state")
	private String state;
	
	@NotNull
	@Pattern(regexp = "[A-Z][a-z]{2,}(\s[A-Z][a-z]*)*", message = "Invalid Country")
	private String country;
	
	@NotNull
	@Min(value = 100001, message = "Invalid pin")
	@Max(value = 999999, message = "Invalid pin")
	private Integer zip;
}
