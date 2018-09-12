package com.metacube.training.EADSession10EmployeePortal.dao;

import java.util.List;

import com.metacube.training.EADSession10EmployeePortal.models.Job;

public interface JobDAO {
	Job getJobById(int id);

	List<Job> getAllJobs();

	boolean deleteJob(Job job);

	boolean updateJob(Job job);

	boolean createJob(Job job);
}
