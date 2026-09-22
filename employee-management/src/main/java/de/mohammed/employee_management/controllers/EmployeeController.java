package de.mohammed.employee_management.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Getter;

@RestController
@RequestMapping("employee")
public class EmployeeController {
	
	@GetMapping
	public String helloWorld() {
		return "Hello Spring Employee World :-)";
	}

}
