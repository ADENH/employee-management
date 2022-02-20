package com.edts.employee.model.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmployeeReq {

	private Long employeeId;
	private String name;
	private Long salary;
	private Long grade;
	
}
