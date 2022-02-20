package com.edts.employee.service;

import org.springframework.http.ResponseEntity;

import com.edts.employee.model.dto.request.GradeReq;

public interface GradeService {

	ResponseEntity<?> getAllGrades();

	ResponseEntity<?> saveGrade(GradeReq body);

	ResponseEntity<?> getGrades(Long id);

}
