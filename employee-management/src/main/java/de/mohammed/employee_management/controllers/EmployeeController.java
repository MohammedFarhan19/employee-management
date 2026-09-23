package de.mohammed.employee_management.controllers;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
					,
			new Employee(UUID.randomUUID()
					, "Thomas"
					, "Schmidt"
					, "t.schmidt@musteremail.de"
					, "26598"
					, LocalDate.of(1999, Month.DECEMBER, 3)
					, "Sales"
					, UUID.randomUUID())
			)
			);
			
	
	@GetMapping
	public String helloWorld() {
		return "Hello Spring Employee World :-)";
	}
	
	@GetMapping("/meineEmployees")
	public ArrayList<Employee> findAllEmployees(){
		return employees;
	}
	
	/**
	 * Methode um einen bestimmten Employee zu finden je nach id
	 * @return Employee
	 */
	@GetMapping("/{employeeId}")
	public Optional<Employee> findEinenEmployee(@PathVariable UUID employeeId) {
		Optional<Employee> employee = employees.stream()
				 .filter(emp -> emp.getId().equals(employeeId))
				 .findFirst();
		return employee;
		
	}
	
	@PostMapping
	public Employee createOne(@RequestBody Employee employee) {
//		System.out.println(employee.getFirstName());
		employee.setId(UUID.randomUUID());
		employee.setDepartmentId(UUID.randomUUID());
		employees.add(employee);
		return employee;
	}
	
	/**
	 * Methode um ein Employee zu löschen
	 * @param employeeId
	 */
	@DeleteMapping("/{employeeId}")
	public void deleteOne(@PathVariable UUID employeeId) {
		Optional<Employee> employee = employees.stream()
			     .filter(emp -> emp.getId().equals(employeeId))
			     .findFirst();
		
		if(employee.isPresent()) {
			employees.remove(employee.get());
		}
	}
	
	
	/**
	 * Methode um ein Employee zu updaten
	 * @param employeeId
	 * @param employee
	 * @return
	 */
	@PutMapping("/{employeeId}")
		public Employee updateOne(@PathVariable UUID employeeId, @RequestBody Employee employee) {
			Optional<Employee> empOptional = employees.stream()
												      .filter(emp -> emp.getId().equals(employeeId))
												      .findFirst();
			if(empOptional.isPresent()) {
				empOptional.get().setFirstName(employee.getFirstName());
				empOptional.get().setLastName(employee.getLastName());
				empOptional.get().setEmail(employee.getEmail());
				empOptional.get().setPhoneNumber(employee.getPhoneNumber());
				empOptional.get().setPosition(employee.getPosition());
				empOptional.get().setHireDate(employee.getHireDate());
				empOptional.get().setFirstName(employee.getFirstName());
				empOptional.get().setDepartmentId(employee.getDepartmentId());
			}
			return employee;
		}
}












