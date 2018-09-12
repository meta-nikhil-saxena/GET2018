package com.metacube.training.EADSession10EmployeePortal.dao;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metacube.training.EADSession10EmployeePortal.models.Employee;

@Repository
@Transactional
public class SearchDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private final String SQL_SEARCH = "FROM Employee WHERE firstname = :firstname";

	@SuppressWarnings("unchecked")
	public Employee search(String name) {
		TypedQuery<Employee> query = sessionFactory.getCurrentSession()
				.createQuery(SQL_SEARCH);
		query.setParameter("firstname", name);
		return query.getSingleResult();
	}
}
