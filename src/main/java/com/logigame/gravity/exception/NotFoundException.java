package com.logigame.gravity.exception;

public class NotFoundException extends Exception{
	private String message;

	public NotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
