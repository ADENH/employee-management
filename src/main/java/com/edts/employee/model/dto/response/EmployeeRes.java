package com.edts.employee.model.dto.response;

import com.edts.employee.model.entity.Grade;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRes {

	private Long employeeId;
	private String name;
	private Grade grade;
	private Long salary;
	private Double bonus;
}
