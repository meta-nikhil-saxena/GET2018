package com.metacube.training.EADSession10EmployeePortal.services;

import java.util.List;

import com.metacube.training.EADSession10EmployeePortal.models.Employee;

public interface EmployeeService {
	Employee getEmployeeById(int id);

	List<Employee> getAllEmployee();

	boolean deleteEmployee(int id);

	boolean updateEmployee(Employee employee);

	boolean createEmployee(Employee employee);

	boolean updatePassword(String username, String password);
	
	boolean checkByEmailAndPassword(String username, String password);
	
	boolean checkByEmail(String email);
	
	Employee getEmployeeByName(String email);
}
