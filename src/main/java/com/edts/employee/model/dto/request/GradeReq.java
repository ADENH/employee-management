package com.edts.employee.model.dto.request;

import lombok.Getter;
import lombok.ToString;
import lombok.Setter;

@Getter
@Setter
@ToString()
public class GradeReq {

	private Long gradeCode;
	private String gradeDesc;
}
