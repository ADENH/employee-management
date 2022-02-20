package com.edts.employee.service;

import org.springframework.http.ResponseEntity;

import com.edts.employee.model.dto.request.EmployeeReq;

public interface EmployeeService {

	ResponseEntity<?> getAllDataEmployee();

	ResponseEntity<?> saveData(EmployeeReq body);

	ResponseEntity<?> getDataEmployee(Long id);
}
