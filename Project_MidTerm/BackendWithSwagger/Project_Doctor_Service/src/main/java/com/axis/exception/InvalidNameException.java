package com.axis.exception;

public class InvalidNameException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;

	public InvalidNameException(String message) {
		super();
		this.message=message;
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	


}
