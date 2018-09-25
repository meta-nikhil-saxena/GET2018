package com.metacube.training.EAD_EmployeePortal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.EAD_EmployeePortal.models.Employee;
import com.metacube.training.EAD_EmployeePortal.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository<Employee> employeeRepository;

	@Override
	public Employee getEmployeeById(int id) {
		return employeeRepository.findOne(id);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public boolean deleteEmployee(int id) {
		Employee employee = employeeRepository.findOne(id);
		employeeRepository.delete(employee);
		return true;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		try {
			employeeRepository.save(employee);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean createEmployee(Employee employee) {
		try {
			employeeRepository.save(employee);
			return true;
		} catch (Exception e) {
			return true;
		}
	}

	@Override
	public boolean updatePassword(String username, String password) {
		return true;
	}

	@Override
	public boolean checkByEmailAndPassword(String email, String password) {
		try {
			employeeRepository.findByEmailAndPassword(email, password);
			return true;
		} catch (Exception e) {
			System.out.println("!!NOT FOOUND!!");
			return false;
		}
	}

	@Override
	public Employee getEmployeeByName(String email) {
		try {
			return employeeRepository.findByEmail(email);
		} catch (Exception e) {
			System.out.println("!! ERROR !! NO SUCH DATA FOUND");
			return null;
		}
	}

	@Override
	public boolean checkEmployeeByEmail(String email) {
		try {
			this.getEmployeeByName(email);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Employee> getByProjectId(int id) {
		return employeeRepository.getByProjectId(id);
	}
}
