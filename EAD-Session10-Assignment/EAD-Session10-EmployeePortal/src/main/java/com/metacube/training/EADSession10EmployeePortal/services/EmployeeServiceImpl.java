package com.metacube.training.EADSession10EmployeePortal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.EADSession10EmployeePortal.dao.EmployeeDAO;
import com.metacube.training.EADSession10EmployeePortal.models.Employee;

@Service
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

	@Override
	public boolean updatePassword(String username, String password) {
		return employeeDAO.updatePassword(username, password);
	}

	@Override
	public boolean checkByEmailAndPassword(String username, String password) {
		return employeeDAO.checkByEmailAndPassword(username, password);
	}

	@Override
	public boolean checkByEmail(String email) {
		return employeeDAO.checkByEmail(email);
	}

	@Override
	public Employee getEmployeeByName(String email) {
		return employeeDAO.getEmployeeByName(email);
	}

}
