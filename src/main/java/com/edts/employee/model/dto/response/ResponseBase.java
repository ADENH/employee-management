package com.edts.employee.model.dto.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseBase implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;
	int status;
}
