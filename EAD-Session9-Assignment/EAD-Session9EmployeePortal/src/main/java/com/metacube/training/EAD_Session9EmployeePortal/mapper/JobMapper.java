package com.metacube.training.EAD_Session9EmployeePortal.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.EAD_Session9EmployeePortal.models.Job;

public class JobMapper implements RowMapper<Job> {

	@Override
	public Job mapRow(ResultSet rs, int rowNum) throws SQLException {
		Job job = new Job();
		job.setId(rs.getInt("id"));
		job.setJob(rs.getString("job"));
		return job;
	}

}
