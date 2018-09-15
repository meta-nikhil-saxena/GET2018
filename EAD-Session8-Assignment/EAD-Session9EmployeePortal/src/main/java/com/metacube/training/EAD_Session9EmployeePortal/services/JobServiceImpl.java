package com.metacube.training.EAD_Session9EmployeePortal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.metacube.training.EAD_Session9EmployeePortal.dao.JobDAO;
import com.metacube.training.EAD_Session9EmployeePortal.models.Job;

public class JobServiceImpl implements JobService {

	@Autowired
	private JobDAO jobDAO;
	
	@Override
	public Job getJobById(int id) {
		return jobDAO.getJobById(id);
	}

	@Override
	public List<Job> getAllJobs() {
		return jobDAO.getAllJobs();
	}

	@Override
	public boolean deleteJob(int id) {
		Job job = jobDAO.getJobById(id);
		return jobDAO.deleteJob(job);
	}

	@Override
	public boolean updateJob(Job job) {
		return jobDAO.updateJob(job);
	}

	@Override
	public boolean createJob(Job job) {
		return jobDAO.createJob(job);
	}
}
