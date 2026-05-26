package com.rbu.service;

public class InvalidBookException extends RuntimeException {

	public InvalidBookException() {
	}

	public InvalidBookException(String message) {
		super(message);
	}

}
