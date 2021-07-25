package com.logigame.gravity.exception;

public class InvalidGameException extends Exception {
	private String message;

	public InvalidGameException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
