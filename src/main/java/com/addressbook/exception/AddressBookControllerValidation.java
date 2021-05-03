package com.addressbook.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.addressbook.dto.ResponseDTO;

@ControllerAdvice
public class AddressBookControllerValidation {
	
	private static final String message = "Error while processing request";
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> hanleMethodArgumentNotValid(
									MethodArgumentNotValidException exception){
		List<String> errorMsgs = exception.getAllErrors()
										  .stream()	
										  .map(error -> error.getDefaultMessage())
										  .collect(Collectors.toList());
		return new ResponseEntity<>(
				new ResponseDTO(errorMsgs, message), HttpStatus.BAD_REQUEST);
	}
}
