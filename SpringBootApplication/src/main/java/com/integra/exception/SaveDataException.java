package com.integra.exception;

public class SaveDataException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6133725801834191458L;

	public SaveDataException() {
		super("Unable to Save Data");
	}

	public SaveDataException(String message) {
		super(message);
	}


}
