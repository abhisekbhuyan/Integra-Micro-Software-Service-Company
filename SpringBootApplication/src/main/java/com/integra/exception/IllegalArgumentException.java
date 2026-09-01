package com.integra.exception;

public class IllegalArgumentException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3785368540241965377L;
	
	public IllegalArgumentException() {
		super("IllegalArgumentException Occured");
	}

	public IllegalArgumentException(String message) {
		super(message);
	}

}
