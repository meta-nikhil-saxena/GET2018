package com.metacube.training.EAD_Session9EmployeePortal.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.EAD_Session9EmployeePortal.models.Employee;

public class EmployeeMapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee();
		
		employee.setId(rs.getInt("id"));
		employee.setProfileImage(rs.getString("profileImage"));
		employee.setFirstName(rs.getString("firstname"));
		employee.setLastname(rs.getString("lastname"));
		employee.setEmail(rs.getString("email"));
		employee.setDob(rs.getDate("dob"));
		employee.setEmployee_id(rs.getString("employee_id"));
		employee.setGender(rs.getString("gender"));
		employee.setPrimarycontact(rs.getString("primarycontact"));
		employee.setSecondarycontact(rs.getString("secondarycontact"));
		employee.setSkills(rs.getString("skills"));
		employee.setStatus(rs.getBoolean("status"));
		return employee;
	}

}
