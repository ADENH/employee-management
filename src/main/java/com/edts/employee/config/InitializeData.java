package com.edts.employee.config;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.edts.employee.model.entity.Employee;
import com.edts.employee.model.entity.Grade;
import com.edts.employee.repository.EmployeeRepository;
import com.edts.employee.repository.GradeRepository;

@Component
public class InitializeData {
	
	@Autowired
	GradeRepository gradeRepo;
	
	@Autowired
	EmployeeRepository employeeRepo;
	
	@EventListener
	public void appReady(ApplicationReadyEvent event) {
		
		initializeDataGrade();
		initializeDataEmployee();

	}

	private void initializeDataGrade() {
		Grade manager = new Grade();
		manager.setGradeCode(1L);
		manager.setBonus(10L);
		manager.setGradeDesc("Manager");
		
		Grade supervisor = new Grade();
		supervisor.setGradeCode(2L);
		supervisor.setBonus(6L);
		supervisor.setGradeDesc("Supervisor");
		
		Grade staff = new Grade();
		staff.setGradeCode(3L);
		staff.setBonus(3L);
		staff.setGradeDesc("Staff");
		
		gradeRepo.save(manager);
		gradeRepo.save(supervisor);
		gradeRepo.save(staff);
		
	}
	
	private void initializeDataEmployee() {
		
		Grade manager = gradeRepo.findByGradeCode(1L).orElseThrow(() -> new NoSuchElementException("No grade data"));
		Grade supervisor = gradeRepo.findByGradeCode(2L).orElseThrow(() -> new NoSuchElementException("No grade data"));
		Grade staff = gradeRepo.findByGradeCode(3L).orElseThrow(() -> new NoSuchElementException("No grade data"));
		
		
		Employee jonah = new Employee();
		jonah.setEmployeeId(10001L);
		jonah.setGrade(manager);
		jonah.setName("Jonah Bluesky");
		jonah.setSalary(7563000L);
		
		Employee stevenson= new Employee();
		stevenson.setEmployeeId(10002L);
		stevenson.setGrade(supervisor);
		stevenson.setName("Stevenson Black");
		stevenson.setSalary(5124000L);
		
		Employee susan= new Employee();
		susan.setEmployeeId(10003L);
		susan.setGrade(staff);
		susan.setName("Susan Random");
		susan.setSalary(3980000L);
		
		employeeRepo.save(jonah);
		employeeRepo.save(stevenson);
		employeeRepo.save(susan);
	}

}
