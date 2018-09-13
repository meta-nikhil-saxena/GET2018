package com.metacube.training.EADSession10EmployeePortal.dao;

import java.util.List;

import com.metacube.training.EADSession10EmployeePortal.models.EmployeeSkills;
import com.metacube.training.EADSession10EmployeePortal.models.Skill;

public interface SkillDAO {

	Skill getSkillById(int id);

	List<Skill> getAllSkill();

	boolean deleteSkill(Skill skill);

	boolean updateSkill(Skill skill);

	boolean createSkill(Skill skill);
	
	boolean insertInSkillRelation(EmployeeSkills skill);
	
	Skill getSkillByName(String name);
}
