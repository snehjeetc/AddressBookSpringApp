package com.addressbook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "address_table")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer address_id;
	
	@NotNull
	@Pattern(regexp = "^[a-zA-Z0-9-/]+",message = "Invalid House number")
	private String houseNo;
	
	@NotNull
	@Pattern(regexp = "[A-Z][a-z]{2,}(\s[A-Z][a-z]*)+", message = "Invalid locality")
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
