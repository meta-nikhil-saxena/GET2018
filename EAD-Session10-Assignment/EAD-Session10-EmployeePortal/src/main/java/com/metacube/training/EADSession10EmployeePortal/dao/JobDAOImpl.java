package com.metacube.training.EADSession10EmployeePortal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.EADSession10EmployeePortal.mapper.JobMapper;
import com.metacube.training.EADSession10EmployeePortal.models.Job;

@Repository
public class JobDAOImpl implements JobDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JobDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private final String SQL_FIND_JOB = "select * from job_title_master where id = ?";
	private final String SQL_DELETE_JOB = "delete from job_title_master where id = ?";
	private final String SQL_UPDATE_JOB = "update job_title_master set job= ? WHERE id=?";
	private final String SQL_GET_ALL = "select * from job_title_master";
	private final String SQL_INSERT_JOB = "insert into job_title_master(job) values(?)";

	@Override
	public Job getJobById(int id) {
		return jdbcTemplate.queryForObject(SQL_FIND_JOB, new Object[] { id },
				new JobMapper());
	}

	@Override
	public List<Job> getAllJobs() {
		return jdbcTemplate.query(SQL_GET_ALL, new JobMapper());
	}

	@Override
	public boolean deleteJob(Job job) {
		return jdbcTemplate.update(SQL_DELETE_JOB, job.getId()) > 0;
	}

	@Override
	public boolean updateJob(Job job) {
		return jdbcTemplate.update(SQL_UPDATE_JOB, job.getJob(), job.getId()) > 0;
	}

	@Override
	public boolean createJob(Job job) {
		return jdbcTemplate.update(SQL_INSERT_JOB, job.getJob()) > 0;
	}

}
