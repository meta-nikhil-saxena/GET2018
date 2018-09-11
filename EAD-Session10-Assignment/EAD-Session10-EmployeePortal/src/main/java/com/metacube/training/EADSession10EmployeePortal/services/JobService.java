package com.metacube.training.EADSession10EmployeePortal.services;

import java.util.List;

import com.metacube.training.EADSession10EmployeePortal.models.Job;

public interface JobService {
	Job getJobById(int id);

	List<Job> getAllJobs();

	boolean deleteJob(int id);

	boolean updateJob(Job job);

	boolean createJob(Job job);
}
