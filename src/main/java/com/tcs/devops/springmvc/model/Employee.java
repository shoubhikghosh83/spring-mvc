package com.tcs.devops.springmvc.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee {

	
	private Integer empId;
	private String empName;
	private String empAddress;
	private String empDiv;
	private Integer empSal;
	private Integer empAge;
	private Integer empExp;
	private String empGen;
	
	
}
