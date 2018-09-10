package com.metacube.training.EAD_Session9EmployeePortal.dao;

import java.util.List;

import com.metacube.training.EAD_Session9EmployeePortal.models.Employee;

public interface EmployeeDAO {
    Employee getEmployeeById(int id);

	List<Employee> getAllEmployee();

	boolean deleteEmployee(Employee employee);

	boolean updateEmployee(Employee employee);

	boolean createEmployee(Employee employee);
}
