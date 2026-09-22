package de.mohammed.employee_management.entity;

import java.time.LocalDate;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
/**
 * using Lombok
 */

@Getter
@Setter
@AllArgsConstructor
public class Employee {

	private UUID id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private LocalDate hireDate;
	private String postion;
	private UUID departmentId;
	
	
}
