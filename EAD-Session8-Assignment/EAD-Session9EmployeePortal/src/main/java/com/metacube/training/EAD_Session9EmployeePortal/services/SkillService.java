package com.metacube.training.EAD_Session9EmployeePortal.services;

import java.util.List;

import com.metacube.training.EAD_Session9EmployeePortal.models.Skill;

public interface SkillService {
	Skill getSkillById(int id);

	List<Skill> getAllSkill();

	boolean deleteSkill(int id);

	boolean updateSkill(Skill skill);

	boolean createSkill(Skill skill);
}
