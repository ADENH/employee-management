package com.edts.employee.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edts.employee.model.entity.Grade;

public interface GradeRepository extends JpaRepository<Grade, Long>{
	
	Optional<Grade> findByGradeCode(Long gradeCode);

}
