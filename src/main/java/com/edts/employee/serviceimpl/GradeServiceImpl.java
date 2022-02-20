package com.edts.employee.serviceimpl;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.edts.employee.model.dto.request.GradeReq;
import com.edts.employee.model.entity.Grade;
import com.edts.employee.repository.GradeRepository;
import com.edts.employee.service.GradeService;
import com.edts.employee.service.ResponseService;

@Service
public class GradeServiceImpl implements GradeService{
	
	@Autowired
	GradeRepository gradeRepo;
	
	@Autowired
	ResponseService responseService;

	@Override
	public ResponseEntity<?> getAllGrades() {
		
		return new ResponseEntity<>(responseService.apiSuccess(gradeRepo.findAll()),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> saveGrade(GradeReq body) {;
		Grade grade = new Grade();
		grade.setGradeCode(body.getGradeCode());
		grade.setGradeDesc(body.getGradeDesc());
		grade = gradeRepo.save(grade);
		return new ResponseEntity<>(responseService.apiSuccess(grade),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getGrades(Long id) {
		Grade grade = gradeRepo.findByGradeCode(id).orElseThrow(() -> new NoSuchElementException("No value present"));
		return new ResponseEntity<>(responseService.apiSuccess(grade),HttpStatus.OK);
	}

}
