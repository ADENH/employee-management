package com.edts.employee.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.edts.employee.model.dto.request.EmployeeReq;
import com.edts.employee.model.dto.response.EmployeeRes;
import com.edts.employee.model.entity.Employee;
import com.edts.employee.model.entity.Grade;
import com.edts.employee.repository.EmployeeRepository;
import com.edts.employee.repository.GradeRepository;
import com.edts.employee.service.EmployeeService;
import com.edts.employee.service.ResponseService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepo;
	
	@Autowired
	GradeRepository gradeRepo;
	
	@Autowired
	ResponseService responseService;

	@Override
	public ResponseEntity<?> getAllDataEmployee() {
		List<Employee> employeeData = employeeRepo.findAll();
		List<EmployeeRes> response = new ArrayList<>();
		for(Employee data: employeeData) {
			EmployeeRes employee = setDataEmployee(data);
			response.add(employee);
		}
		return new ResponseEntity<>(responseService.apiSuccess(response),HttpStatus.OK);
	}

	private EmployeeRes setDataEmployee(Employee data) {
		EmployeeRes employee = new EmployeeRes();
		employee.setEmployeeId(data.getEmployeeId());
		employee.setName(data.getName());
		employee.setGrade(data.getGrade());
		employee.setSalary(data.getSalary());
		Double totalBonus = (double) (data.getSalary() + (data.getSalary()*((double)data.getGrade().getBonus()/100)));
		employee.setBonus(totalBonus);
		return employee;
	}

	@Override
	public ResponseEntity<?> saveData(EmployeeReq body) {
		
		// check grade employee
		Grade gradeEmployee = gradeRepo.findById(body.getGrade()).orElseThrow(() -> new NoSuchElementException("No value present"));
		
		Employee employee = new Employee();
		employee.setEmployeeId(body.getEmployeeId());
		employee.setName(body.getName());
		employee.setSalary(body.getSalary());
		employee.setGrade(gradeEmployee);
		employee = employeeRepo.save(employee);
		
		return new ResponseEntity<>(responseService.apiSuccess(employee),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getDataEmployee(Long id) {
		Employee employee = employeeRepo.findByEmployeeId(id).orElseThrow(() -> new NoSuchElementException("No value present"));
		EmployeeRes res = setDataEmployee(employee);
		return new ResponseEntity<>(responseService.apiSuccess(res),HttpStatus.OK);
	}

}
