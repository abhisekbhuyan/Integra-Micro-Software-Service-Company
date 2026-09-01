package com.integra.exception;

public class IllegalAccessException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6733978376014631866L;
	
	public IllegalAccessException() {
		super("IllegalArgumentException Occured");
	}

	public IllegalAccessException(String message) {
		super(message);
	}

}
