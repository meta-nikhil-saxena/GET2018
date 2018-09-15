package com.metacube.training.EAD_EmployeePortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.EAD_EmployeePortal.models.Skill;

public interface SkillRepository<S> extends JpaRepository<Skill, Integer> {

	Skill findByTitle(String title);
}
