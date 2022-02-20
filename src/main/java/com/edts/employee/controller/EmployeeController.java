package com.edts.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edts.employee.model.dto.request.EmployeeReq;
import com.edts.employee.service.EmployeeService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@GetMapping("")
	public ResponseEntity<?> getAllEmployee(){
		return service.getAllDataEmployee();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getEmployee(@PathVariable Long id){
		return service.getDataEmployee(id);
	}
	
	@PostMapping("")
	public ResponseEntity<?> saveDataEmployee(@RequestBody EmployeeReq body){
		return service.saveData(body);
	}
	
}
