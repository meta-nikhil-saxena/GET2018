package com.metacube.training.EAD_Session9EmployeePortal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.EAD_Session9EmployeePortal.dao.SearchDAO;
import com.metacube.training.EAD_Session9EmployeePortal.models.Employee;

@Service
public class SearchService {

	@Autowired
	private SearchDAO searchDAO;
	
	public Employee search(String name) {
		return searchDAO.search(name);
	}
}
