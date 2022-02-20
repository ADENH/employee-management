package com.edts.employee.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edts.employee.model.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	Optional<Employee> findByEmployeeId(Long employeeId);

}
