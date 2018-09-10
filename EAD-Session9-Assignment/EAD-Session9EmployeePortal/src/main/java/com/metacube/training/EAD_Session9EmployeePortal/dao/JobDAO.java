package com.metacube.training.EAD_Session9EmployeePortal.dao;

import java.util.List;

import com.metacube.training.EAD_Session9EmployeePortal.models.Job;

public interface JobDAO {
	Job getJobById(int id);

	List<Job> getAllJobs();

	boolean deleteJob(Job job);

	boolean updateJob(Job job);

	boolean createJob(Job job);
}
