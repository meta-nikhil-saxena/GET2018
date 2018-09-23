package com.metacube.training.EAD_EmployeePortal.services;

import java.util.List;

import com.metacube.training.EAD_EmployeePortal.models.Employee;

public interface EmployeeService {
	Employee getEmployeeById(int id);

	List<Employee> getAllEmployee();

	boolean deleteEmployee(int id);

	boolean updateEmployee(Employee employee);

	boolean createEmployee(Employee employee);

	boolean updatePassword(String username, String password);
	
	boolean checkByEmailAndPassword(String username, String password);
	
	Employee getEmployeeByName(String email);
	
	boolean checkEmployeeByEmail(String email);
	
	List<Employee> getByProjectId(int id);
}
