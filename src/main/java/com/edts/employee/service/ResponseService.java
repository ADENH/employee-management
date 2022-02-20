package com.edts.employee.service;

import com.edts.employee.model.dto.response.ResponseBase;
import com.edts.employee.model.dto.response.ResponseSchema;

public interface ResponseService {

	<T> ResponseSchema<T> apiSuccess(T data);
	ResponseBase apiError(String pesan);
	ResponseBase apiSuccess(String pesan);
}
