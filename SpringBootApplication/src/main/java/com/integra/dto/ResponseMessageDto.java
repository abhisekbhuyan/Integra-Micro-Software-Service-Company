package com.integra.dto;

import lombok.Data;

@Data
public class ResponseMessageDto {

		private Integer RespCode;
		private String RespStatus;
		private String RespMessage;
		private Object RespBuffer;
}
