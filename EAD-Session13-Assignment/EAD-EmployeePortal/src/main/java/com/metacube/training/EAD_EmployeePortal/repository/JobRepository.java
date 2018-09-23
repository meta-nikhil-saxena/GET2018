package com.metacube.training.EAD_EmployeePortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.EAD_EmployeePortal.models.Job;

public interface JobRepository<J> extends JpaRepository<Job, Integer> {

}
