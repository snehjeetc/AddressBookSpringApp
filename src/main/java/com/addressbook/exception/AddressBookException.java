package com.addressbook.exception;

@SuppressWarnings("serial")
public class AddressBookException extends RuntimeException {
	public enum EXCEPTION_TYPE{
		CONTACT_NOT_FOUND
	}
	
	public final EXCEPTION_TYPE type;
	public AddressBookException(String message, EXCEPTION_TYPE type) {
		super(message);
		this.type = type;
	}
}
