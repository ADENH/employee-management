package com.edts.employee.serviceimpl;

import org.springframework.stereotype.Service;

import com.edts.employee.model.dto.response.ResponseBase;
import com.edts.employee.model.dto.response.ResponseSchema;
import com.edts.employee.service.ResponseService;

@Service
public class ResponseServiceImpl implements ResponseService{
	
	@Override
	public <T> ResponseSchema<T> apiSuccess(T data) {
		ResponseSchema<T> responseSchema = new ResponseSchema<>();
		responseSchema.setData(data);
		responseSchema.setMessage("success");
		responseSchema.setStatus(1);
		return responseSchema;
	}
	
	@Override
	public ResponseBase apiSuccess(String pesan) {
		ResponseBase responseSchema = new ResponseBase(pesan,1);
		return responseSchema;
	}

	@Override
	public ResponseBase apiError(String pesan) {
		ResponseBase responseTemplate = new ResponseBase(pesan,0);
		return responseTemplate;
	}


}
