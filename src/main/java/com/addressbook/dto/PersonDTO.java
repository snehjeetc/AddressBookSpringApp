package com.addressbook.dto;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.addressbook.model.Address;
import com.sun.istack.NotNull;

import lombok.Data;

@Data
public class PersonDTO {
	@NotNull
	@Pattern(regexp = "[A-Z][a-z]{2,}(\s[A-Z][a-z]*)*", message = "Required valid name")
	private String name;
	
	@NotNull
	@Pattern(regexp = "^(?:(?:\\+|0{0,2})91(\\s*[\\ -]\\s*)?|[0]?)?[789]\\d{9}|(\\d[ -]?){10}\\d$", 
	message = "Invalid Phone number")
	private String phoneNumber;
	
	@NotEmpty(message = "email must not be empty")
	@Email(message = "Invalid email")
	private String email;
	
	@Valid
	private Address address;
}
