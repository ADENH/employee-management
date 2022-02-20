package com.edts.employee.config;

import java.util.NoSuchElementException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.edts.employee.model.dto.response.ResponseBase;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
	
	private <T> ResponseEntity<?> buildResponseEntity(T data) {
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	protected ResponseEntity<?> handleEntityNotFound(NoSuchElementException ex) {
		ResponseBase apiError = new ResponseBase(ex.getMessage(),0);
		return buildResponseEntity(apiError);
	}

}
