package com.metacube.training.EAD_EmployeePortal.services;

import java.util.List;

import com.metacube.training.EAD_EmployeePortal.models.Job;

public interface JobService {
	
	Job getJobById(int id);

	List<Job> getAllJobs();

	boolean deleteJob(int id);

	boolean updateJob(Job job);

	boolean createJob(Job job);
}
