package com.metacube.training.EAD_EmployeePortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.EAD_EmployeePortal.models.EmployeeSkills;

public interface SkillRelationRepository<S> extends
		JpaRepository<EmployeeSkills, Integer> {

}
