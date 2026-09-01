package com.integra.exception;

public class CommonNullException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1623667489494174004L;
	
	public CommonNullException() {
		super("Common Null Exception");
	}

	public CommonNullException(String message) {
		super(message);
	}

}
