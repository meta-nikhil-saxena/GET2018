package com.metacube.training.EAD_EmployeePortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.EAD_EmployeePortal.models.Project;

@Repository
@Transactional
public interface ProjectRepository<P> extends JpaRepository<Project, Integer> {
	Project findByProjectName(String name);
}
