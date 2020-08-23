package com.tcs.devops.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.devops.springmvc.model.Employee;
import com.tcs.devops.springmvc.service.Service;

@RestController
@RequestMapping("app")
public class Controller {

	
	final private Service service;
	
	@Autowired
	public Controller(final Service service)
	{
		this.service = service;
	}
	
	@GetMapping(value = "/getEmpById/{id}", produces = "application/json")
	public Employee getEmpById(@PathVariable int id)
	{
		return service.getEmpById(id);
	}
	
	@RequestMapping(value = "/health")
	public String getHealth()
	{
		return "UP";
	}
}
