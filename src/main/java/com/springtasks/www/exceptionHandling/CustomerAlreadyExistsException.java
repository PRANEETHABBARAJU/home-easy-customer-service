package com.springtasks.www.exceptionHandling;

public class CustomerAlreadyExistsException extends RuntimeException {
	public CustomerAlreadyExistsException(String message) {
		super(message);
	}

}
