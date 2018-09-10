package com.metacube.training.EAD_Session9EmployeePortal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.EAD_Session9EmployeePortal.dao.SkillDAO;
import com.metacube.training.EAD_Session9EmployeePortal.models.Skill;

@Service
public class SkillServiceImpl implements SkillService {

	@Autowired
	private SkillDAO skillDAO;
	
	@Override
	public Skill getSkillById(int id) {
		return skillDAO.getSkillById(id);
	}

	@Override
	public List<Skill> getAllSkill() {
		return skillDAO.getAllSkill();
	}

	@Override
	public boolean deleteSkill(int id) {
	Skill skill = skillDAO.getSkillById(id);
	return skillDAO.deleteSkill(skill);
	}

	@Override
	public boolean updateSkill(Skill skill) {
		return skillDAO.deleteSkill(skill);
	}

	@Override
	public boolean createSkill(Skill skill) {
		return skillDAO.createSkill(skill);
	}

	
}
