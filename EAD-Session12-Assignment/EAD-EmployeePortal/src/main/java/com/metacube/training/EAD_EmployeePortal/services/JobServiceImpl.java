package com.metacube.training.EAD_EmployeePortal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.EAD_EmployeePortal.models.Job;
import com.metacube.training.EAD_EmployeePortal.repository.JobRepository;

@Service
public class JobServiceImpl implements JobService {

	@Autowired
	private JobRepository<Job> jobRepository;

	@Override
	public Job getJobById(int id) {
		return jobRepository.findOne(id);
	}

	@Override
	public List<Job> getAllJobs() {
		return jobRepository.findAll();
	}

	@Override
	public boolean deleteJob(int id) {
		Job job = jobRepository.findOne(id);
		jobRepository.delete(job);
		return true;
	}

	@Override
	public boolean updateJob(Job job) {
		try {
			jobRepository.save(job);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean createJob(Job job) {
		jobRepository.save(job);
		return true;
	}
}
