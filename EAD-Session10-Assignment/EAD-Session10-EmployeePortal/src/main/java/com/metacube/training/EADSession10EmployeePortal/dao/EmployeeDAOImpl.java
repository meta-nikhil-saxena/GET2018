package com.metacube.training.EADSession10EmployeePortal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.EADSession10EmployeePortal.mapper.EmployeeMapper;
import com.metacube.training.EADSession10EmployeePortal.models.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public EmployeeDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private final String SQL_FIND_EMPLOYEE = "select * from employees where id = ?";
	private final String SQL_DELETE_EMPLOYEE = "delete from employees where id = ?";
	private final String SQL_UPDATE_EMPLOYEE = "update employees set firstname=?,lastname=?,dob=?,skills=?,gender=?,primarycontact=?,secondarycontact=?,email=?,profileImage=?,password=? WHERE id=?";
	private final String SQL_GET_ALL = "select * from employees";
	private final String SQL_INSERT_EMPLOYEE = "insert into employees(employee_id,firstname,lastname,dob,skills,gender,primarycontact,secondarycontact,email,profileImage,password) values(?,?,?,?,?,?,?,?,?,?,?)";
	private final String SQL_UPDATE_PASSWORD = "update employees set password=? WHERE email=?";
	private final String SQL_CHECK_BY_EMAIL_PASSWORD = "select * from employees WHERE email=? AND password=?";
	private final String SQL_CHECK_BY_EMAIL = "select * from employee WHERE email=?";
	private final String GET_BY_EMAIL = "select * from employees WHERE email=?";

	@Override
	public Employee getEmployeeById(int id) {

		return jdbcTemplate.queryForObject(SQL_FIND_EMPLOYEE,
				new Object[] { id }, new EmployeeMapper());
	}

	@Override
	public List<Employee> getAllEmployee() {
		return jdbcTemplate.query(SQL_GET_ALL, new EmployeeMapper());
	}

	@Override
	public boolean deleteEmployee(Employee employee) {
		return jdbcTemplate.update(SQL_DELETE_EMPLOYEE, employee.getId()) > 0;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		return jdbcTemplate.update(SQL_UPDATE_EMPLOYEE,
				employee.getFirstName(), employee.getLastname(),
				employee.getDob(), employee.getSkills(), employee.getGender(),
				employee.getPrimarycontact(), employee.getSecondarycontact(),
				employee.getEmail(), employee.getProfileImage(),
				employee.getPassword(), employee.getId()) > 0;
	}

	@Override
	public boolean createEmployee(Employee employee) {
		return jdbcTemplate.update(SQL_INSERT_EMPLOYEE,
				employee.getEmployee_id(), employee.getFirstName(),
				employee.getLastname(), employee.getDob(),
				employee.getSkills(), employee.getGender(),
				employee.getPrimarycontact(), employee.getSecondarycontact(),
				employee.getEmail(), employee.getProfileImage(),
				employee.getPassword()) > 0;
	}

	@Override
	public boolean updatePassword(String username, String password) {
		return jdbcTemplate.update(SQL_UPDATE_PASSWORD, password, username) > 0;
	}

	@Override
	public boolean checkByEmailAndPassword(String username, String password) {
		try {
			jdbcTemplate.queryForObject(SQL_CHECK_BY_EMAIL_PASSWORD,
					new Object[] { username, password }, new EmployeeMapper());
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean checkByEmail(String email) {
		Employee employee = jdbcTemplate.queryForObject(SQL_CHECK_BY_EMAIL,
				new Object[] { email }, new EmployeeMapper());
		if (employee != null) {
			return true;
		}
		return false;
	}

	@Override
	public Employee getEmployeeByName(String email) {
		return jdbcTemplate.queryForObject(GET_BY_EMAIL,
				new Object[] { email }, new EmployeeMapper());
	}
}
