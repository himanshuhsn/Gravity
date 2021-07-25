package com.logigame.gravity.exception;

public class InvalidParamException extends Exception {
	private String message;

	public InvalidParamException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
