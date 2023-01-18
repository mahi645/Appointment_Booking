package com.axis.exception;

public class InvalidExperienceException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;

	public InvalidExperienceException(String message) {
		super();
		this.message=message;
	
	}

	public String getMessage() {
		return message;
	}

}
