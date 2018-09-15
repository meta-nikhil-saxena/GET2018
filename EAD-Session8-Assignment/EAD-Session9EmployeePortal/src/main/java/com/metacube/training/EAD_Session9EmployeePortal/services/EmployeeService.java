package com.metacube.training.EAD_Session9EmployeePortal.services;

import java.util.List;

import com.metacube.training.EAD_Session9EmployeePortal.models.Employee;


public interface EmployeeService {
	Employee getEmployeeById(int id);

	List<Employee> getAllEmployee();

	boolean deleteEmployee(int id);

	boolean updateEmployee(Employee employee);

	boolean createEmployee(Employee employee);
}
