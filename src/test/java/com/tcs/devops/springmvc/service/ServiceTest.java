package com.tcs.devops.springmvc.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.tcs.devops.springmvc.model.Employee;

public class ServiceTest {
	

	
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
	
	@Test
	public void getEmpByIdTest()
	{
		assertEquals(getAllEmp().get(0), new Service().getEmpById(10));
	}
	
	@Test
	public void getAllFromRetailTest()
	{
		assertEquals(new Integer(10), new Service().getAllFromRetail().get(0));	
	}
	
	@Test
	public void getAllFromBfsTest()
	{
		assertEquals(new Integer(100), new Service().getAllFromBfs().get(0));	
	}
	
	@Test
	public void getAllMaleEmployeeTest()
	{
		assertEquals(new Integer(10), new Service().getAllMaleEmployee().get(0));	
	}

}
