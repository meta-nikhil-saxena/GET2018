package com.metacube.training.EAD_EmployeePortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.EAD_EmployeePortal.models.JobDetails;

public interface JobDetailsRepository<J> extends
		JpaRepository<JobDetails, Integer> {

}
