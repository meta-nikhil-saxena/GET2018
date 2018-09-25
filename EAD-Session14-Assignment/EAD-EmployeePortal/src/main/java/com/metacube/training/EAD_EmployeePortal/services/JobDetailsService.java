package com.metacube.training.EAD_EmployeePortal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.EAD_EmployeePortal.models.JobDetails;
import com.metacube.training.EAD_EmployeePortal.repository.JobDetailsRepository;

@Service
public class JobDetailsService {

	@Autowired
	private JobDetailsRepository<JobDetails> jobDetailsRepository;

	public boolean insertData(JobDetails jobdetails) {

		try {
			jobDetailsRepository.save(jobdetails);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
