package com.metacube.training.EAD_EmployeePortal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.EAD_EmployeePortal.models.EmployeeSkills;
import com.metacube.training.EAD_EmployeePortal.models.Skill;
import com.metacube.training.EAD_EmployeePortal.repository.SkillRelationRepository;
import com.metacube.training.EAD_EmployeePortal.repository.SkillRepository;

@Service
public class SkillServiceImpl implements SkillService {

	@Autowired
	private SkillRepository<Skill> skillRepository;

	@Autowired
	private SkillRelationRepository<EmployeeSkills> skillRelationRepository;

	@Override
	public Skill getSkillById(int id) {
		return skillRepository.findOne(id);
	}

	@Override
	public List<Skill> getAllSkill() {
		return skillRepository.findAll();
	}

	@Override
	public boolean deleteSkill(int id) {
		Skill skill = skillRepository.findOne(id);
		skillRepository.delete(skill);
		return true;
	}

	@Override
	public boolean updateSkill(Skill skill) {
		try {
			skillRepository.save(skill);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean createSkill(Skill skill) {
		skillRepository.save(skill);
		return true;
	}

	@Override
	public boolean insertInSkillRelation(EmployeeSkills skill) {
		skillRelationRepository.save(skill);
		return true;
	}

	@Override
	public Skill getSkillByName(String name) {
		return skillRepository.findByTitle(name);
	}
}
