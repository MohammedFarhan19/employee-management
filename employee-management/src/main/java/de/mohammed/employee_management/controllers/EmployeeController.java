package de.mohammed.employee_management.controllers;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.mohammed.employee_management.entity.Employee;
import lombok.Getter;

@RestController
@RequestMapping("employee")
public class EmployeeController {

	ArrayList<Employee> employees = new ArrayList<>(
			List.of(new Employee(
					UUID.randomUUID()
					, "John"
					, "Doe"
					, "john.doe@example.de"
					, "012565 23"
					, LocalDate.of(2000, Month.APRIL, 10)
					, "Programmer"
					, UUID.randomUUID())
					)
			);
			
	
	@GetMapping
	public String helloWorld() {
		return "Hello Spring Employee World :-)";
	}
	
	@GetMapping("/meineEmployees")
	public ArrayList<Employee> getAllEmployees(){
		return employees;
	}

}
