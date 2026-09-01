package com.integra.utils;

import org.springframework.stereotype.Component;

import com.integra.dto.ResponseMessageDto;
import java.lang.reflect.Field;

@Component
public class CommonUtils {
	
	public static ResponseMessageDto createSuccessResponse(Integer respCode, String respStatus, String respMessage,
			Object respBuffer) {
		ResponseMessageDto ResponseMessageDto = new ResponseMessageDto();
		ResponseMessageDto.setRespCode(respCode);
		ResponseMessageDto.setRespStatus(respStatus);
		ResponseMessageDto.setRespMessage(respMessage);
		ResponseMessageDto.setRespBuffer(respBuffer);
		return ResponseMessageDto;
	}
	
	public static ResponseMessageDto createErrorResponse(Integer respCode, String respStatus, String respMessage) {
		ResponseMessageDto ResponseMessageDto = new ResponseMessageDto();
		ResponseMessageDto.setRespCode(respCode);
		ResponseMessageDto.setRespStatus(respStatus);
		ResponseMessageDto.setRespMessage(respMessage);
		return ResponseMessageDto;
	}
	

	    public static void copyNonNullProperties(Object source, Object target) throws IllegalArgumentException, IllegalAccessException {
	        Class<?> sourceClass = source.getClass();
	        Class<?> targetClass = target.getClass();

	        Field[] sourceFields = sourceClass.getDeclaredFields();
	        for (Field field : sourceFields) {
	            field.setAccessible(true);
	            Object value = field.get(source);
	            if (value != null) {
	                try {
	                    Field targetField = targetClass.getDeclaredField(field.getName());
	                    targetField.setAccessible(true);
	                    targetField.set(target, value);
	                } catch (NoSuchFieldException e) {
	                    // Ignore if the field doesn't exist in the target object
	                } catch (IllegalAccessException | IllegalArgumentException e) {
	                    throw e; // Throw the exceptions if encountered
	                }
	            }
	        }
	}


}
