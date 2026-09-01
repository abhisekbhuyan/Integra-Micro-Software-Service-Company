package com.integra.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.integra.dto.ResponseMessageDto;
import com.integra.utils.CommonUtils;

@RestControllerAdvice
public class CustomExceptionHandler {
	
	@ExceptionHandler(SaveDataException.class)
	public final ResponseMessageDto handleSaveDataExceptions(SaveDataException ex) {
		return CommonUtils.createErrorResponse(408, "ERROR",
				ex.getMessage());
	}
	@ExceptionHandler(CommonNullException.class)
	public final ResponseMessageDto handleNullExceptions(CommonNullException ex) {
		return CommonUtils.createErrorResponse(408, "ERROR",
				ex.getMessage());
	}
	
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public final ResponseMessageDto handleEmployeeNotFoundExceptions(EmployeeNotFoundException ex) {
		return CommonUtils.createErrorResponse(408, "ERROR",
				ex.getMessage());
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public final ResponseMessageDto handleIllegalArgumentExceptions(IllegalArgumentException ex) {
		return CommonUtils.createErrorResponse(408, "ERROR",
				ex.getMessage());
	}
	@ExceptionHandler(IllegalAccessException.class)
	public final ResponseMessageDto handleIllegalAccessExceptions(IllegalAccessException ex) {
		return CommonUtils.createErrorResponse(408, "ERROR",
				ex.getMessage());
	}
}
