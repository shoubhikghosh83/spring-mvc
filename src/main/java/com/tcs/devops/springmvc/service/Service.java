package com.tcs.devops.springmvc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.tcs.devops.springmvc.model.Employee;

@org.springframework.stereotype.Service
public class Service {
	
	private List<Employee> getAllEmp()
	{
		Employee e1 = Employee.builder().empId(10).empName("EMP1").empAddress("Kolkata")
				.empAge(40).empDiv("Retail").empExp(10).empGen("M").empSal(100000).build();
		Employee e2 = Employee.builder().empId(11).empName("EMP2").empAddress("Kolkata")
				.empAge(40).empDiv("Retail").empExp(10).empGen("M").empSal(200000).build();
		Employee e3 = Employee.builder().empId(100).empName("EMP3").empAddress("Mumbai")
				.empAge(40).empDiv("BFS").empExp(10).empGen("F").empSal(300000).build();
		
		List<Employee> allemp = new ArrayList<Employee>();
		allemp.add(e1);allemp.add(e2);allemp.add(e3);
		return allemp;
	}
	
	public Employee getEmpById(Integer empId)
	{
		return getAllEmp().stream().filter(e -> e.getEmpId() == empId ).collect(Collectors.toList()).get(0);
	}
	
	public List<Integer> getAllFromRetail()
	{
		return getAllEmp().stream().filter(e -> e.getEmpDiv().equals("Retail")).map(e -> e.getEmpId()).collect(Collectors.toList());
	}
	
	public List<Integer> getAllFromBfs()
	{
		return getAllEmp().stream().filter(e -> e.getEmpDiv().equals("BFS")).map(e -> e.getEmpId()).collect(Collectors.toList());
	}
	
	public List<Integer> getAllMaleEmployee()
	{
		return getAllEmp().stream().filter(e -> e.getEmpGen().equals("M")).map(e -> e.getEmpId()).collect(Collectors.toList());
	}
	public List<Integer> getAllFemaleEmployee()
	{
		return getAllEmp().stream().filter(e -> e.getEmpGen().equals("F")).map(e -> e.getEmpId()).collect(Collectors.toList());
	}
	public List<Integer> getAllEmployeeEasternZone()
	{
		return getAllEmp().stream().filter(e -> e.getEmpAddress().equals("Kolkata")).map(e -> e.getEmpId()).collect(Collectors.toList());
	}
	public List<Integer> getAllEmployeeWesternZone()
	{
		return getAllEmp().stream().filter(e -> e.getEmpAddress().equals("Mumbai")).map(e -> e.getEmpId()).collect(Collectors.toList());
	}
	
	public Employee getEmpByName(String name)
	{
		return getAllEmp().stream().filter(e -> e.getEmpName().equals(name) ).collect(Collectors.toList()).get(0);
	}
	
	public List<Integer> getAllEmployeeSalLess250K()
	{
		return getAllEmp().stream().filter(e -> e.getEmpSal()<250000).map(e -> e.getEmpId()).collect(Collectors.toList());
	}
	public List<Integer> getAllEmployeeSalGrt250K()
	{
		return getAllEmp().stream().filter(e -> e.getEmpSal()>250000).map(e -> e.getEmpId()).collect(Collectors.toList());
	}
	public static void main(String[] args) {
		
		
		System.out.println(new Service().getAllFromRetail());
	}

}
