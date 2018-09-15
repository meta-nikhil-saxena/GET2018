package com.metacube.training.EADSession10EmployeePortal.dao;

import java.util.List;

import com.metacube.training.EADSession10EmployeePortal.models.Employee;

public interface EmployeeDAO {
	Employee getEmployeeById(int id);

	List<Employee> getAllEmployee();

	boolean deleteEmployee(Employee employee);

	boolean updateEmployee(Employee employee);

	boolean createEmployee(Employee employee);

	boolean updatePassword(String username, String password);

	boolean checkByEmailAndPassword(String username, String password);

	boolean checkByEmail(String email);
	
	Employee getEmployeeByName(String email);
}
