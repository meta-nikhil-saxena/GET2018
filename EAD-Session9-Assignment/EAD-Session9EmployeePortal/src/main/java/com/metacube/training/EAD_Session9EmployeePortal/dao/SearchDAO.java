package com.metacube.training.EAD_Session9EmployeePortal.dao;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.metacube.training.EAD_Session9EmployeePortal.mapper.EmployeeMapper;
import com.metacube.training.EAD_Session9EmployeePortal.models.Employee;

@Repository
public class SearchDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public SearchDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private final String SQL_SEARCH = "SELECT * FROM employees WHERE firstname = ?";

	public Employee search(String name) {
		return jdbcTemplate.queryForObject(SQL_SEARCH, new Object[] { name },
				new EmployeeMapper());
	}
}
