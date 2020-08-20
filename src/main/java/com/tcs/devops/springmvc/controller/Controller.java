package com.tcs.devops.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.devops.springmvc.model.Employee;
import com.tcs.devops.springmvc.service.Service;

@RestController
public class Controller {

	
	final private Service service;
	
	@Autowired
	public Controller(final Service service)
	{
		this.service = service;
	}
	
	@RequestMapping(value = "/getEmpById/{id}")
	public Employee getEmpById(@PathVariable Integer id)
	{
		return service.getEmpById(id);
	}
}
