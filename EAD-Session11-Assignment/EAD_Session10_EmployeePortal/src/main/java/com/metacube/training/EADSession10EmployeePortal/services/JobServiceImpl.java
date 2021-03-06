package com.metacube.training.EADSession10EmployeePortal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.EADSession10EmployeePortal.dao.JobDAO;
import com.metacube.training.EADSession10EmployeePortal.models.Job;

@Service
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
