package com.edts.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edts.employee.model.dto.request.GradeReq;
import com.edts.employee.service.GradeService;

@RestController
@RequestMapping("/grades")
public class GradeController {
	
	@Autowired
	GradeService service;

	@GetMapping("")
	public ResponseEntity<?> getAllGrades(){
		return service.getAllGrades();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getGrades(@PathVariable Long id){
		return service.getGrades(id);
	}
	
	@PostMapping("/")
	public ResponseEntity<?> saveGrade(@RequestBody GradeReq body){
		return service.saveGrade(body);
	}
}
