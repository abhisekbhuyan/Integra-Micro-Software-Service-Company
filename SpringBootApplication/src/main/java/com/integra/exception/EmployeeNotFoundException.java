package com.integra.exception;

public class EmployeeNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3722367786165131461L;
	
	public EmployeeNotFoundException() {
		super("Given Id Employee Not Found");
	}

	public EmployeeNotFoundException(String message) {
		super(message);
	}

}
