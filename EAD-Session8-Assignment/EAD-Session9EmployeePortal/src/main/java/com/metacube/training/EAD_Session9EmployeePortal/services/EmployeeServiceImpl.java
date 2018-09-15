package com.metacube.training.EAD_Session9EmployeePortal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.metacube.training.EAD_Session9EmployeePortal.dao.EmployeeDAO;
import com.metacube.training.EAD_Session9EmployeePortal.models.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Override
	public Employee getEmployeeById(int id) {
		return employeeDAO.getEmployeeById(id);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeDAO.getAllEmployee();
	}

	@Override
	public boolean deleteEmployee(int id) {
		Employee employee = employeeDAO.getEmployeeById(id);
		return employeeDAO.deleteEmployee(employee);
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		return employeeDAO.updateEmployee(employee);
	}

	@Override
	public boolean createEmployee(Employee employee) {
		return employeeDAO.createEmployee(employee);
	}

}
