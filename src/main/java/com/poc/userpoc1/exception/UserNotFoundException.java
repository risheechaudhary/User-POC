package com.poc.userpoc1.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class UserNotFoundException extends RuntimeException {
	
	public UserNotFoundException(Long id) {
		// TODO Auto-generated constructor stub
		super("user not found with id");
	}
	
	UserNotFoundException(){

	}
}