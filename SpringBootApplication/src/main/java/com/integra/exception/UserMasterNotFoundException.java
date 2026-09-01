package com.integra.exception;

public class UserMasterNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserMasterNotFoundException(String message) {
        super(message);
    }
}