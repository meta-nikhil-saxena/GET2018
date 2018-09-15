package com.metacube.training.EAD_Session9EmployeePortal.dao;

import java.util.List;

import com.metacube.training.EAD_Session9EmployeePortal.models.Skill;

public interface SkillDAO {

	Skill getSkillById(int id);

	List<Skill> getAllSkill();

	boolean deleteSkill(Skill skill);

	boolean updateSkill(Skill skill);

	boolean createSkill(Skill skill);
}
