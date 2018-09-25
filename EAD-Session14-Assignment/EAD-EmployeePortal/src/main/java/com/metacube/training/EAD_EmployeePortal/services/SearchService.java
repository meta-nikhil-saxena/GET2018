package com.metacube.training.EAD_EmployeePortal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.EAD_EmployeePortal.models.Employee;
import com.metacube.training.EAD_EmployeePortal.repository.EmployeeRepository;

@Service
public class SearchService {

	@Autowired
	private EmployeeRepository<Employee> employeeRepository;

	public Employee search(String name) {
		return employeeRepository.findByfirstName(name);
	}
}
