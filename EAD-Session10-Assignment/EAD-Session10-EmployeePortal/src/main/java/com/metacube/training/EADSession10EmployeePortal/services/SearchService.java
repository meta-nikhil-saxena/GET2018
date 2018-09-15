package com.metacube.training.EADSession10EmployeePortal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.EADSession10EmployeePortal.dao.SearchDAO;
import com.metacube.training.EADSession10EmployeePortal.models.Employee;

@Service
public class SearchService {

	@Autowired
	private SearchDAO searchDAO;
	
	public Employee search(String name) {
		return searchDAO.search(name);
	}
}
