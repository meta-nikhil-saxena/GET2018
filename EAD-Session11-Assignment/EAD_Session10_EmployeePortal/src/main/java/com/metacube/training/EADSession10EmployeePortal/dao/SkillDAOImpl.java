package com.metacube.training.EADSession10EmployeePortal.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metacube.training.EADSession10EmployeePortal.models.EmployeeSkills;
import com.metacube.training.EADSession10EmployeePortal.models.Skill;

@Repository
@Transactional
public class SkillDAOImpl implements SkillDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private final String SQL_FIND_SKILL = "from Skill where id = :skillId";
	private final String SQL_FIND_SKILL_BY_NAME = "from Skill where title = :skillName";
	private final String SQL_DELETE_SKILL = "delete from Skill where id = :skillId";
	private final String SQL_UPDATE_SKILL = "update Skill set title=:title WHERE id= :skillId";
	private final String SQL_GET_ALL = "from Skill";

	@SuppressWarnings("unchecked")
	@Override
	public Skill getSkillById(int id) {
		TypedQuery<Skill> query = sessionFactory.getCurrentSession()
				.createQuery(SQL_FIND_SKILL);
		query.setParameter("skillId", id);
		return query.getSingleResult();
	}

	@Override
	public List<Skill> getAllSkill() {
		@SuppressWarnings("unchecked")
		TypedQuery<Skill> query = sessionFactory.getCurrentSession()
				.createQuery(SQL_GET_ALL);

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean deleteSkill(Skill skill) {
		TypedQuery<Skill> query = sessionFactory.getCurrentSession()
				.createQuery(SQL_DELETE_SKILL);

		query.setParameter("skillId", skill.getId());
		return (query.executeUpdate() > 0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean updateSkill(Skill skill) {
		TypedQuery<Skill> query = sessionFactory.getCurrentSession()
				.createQuery(SQL_UPDATE_SKILL);
		query.setParameter("title", skill.getTitle());
		query.setParameter("skillId", skill.getId());
		return (query.executeUpdate() > 0);
	}

	@Override
	public boolean createSkill(Skill skill) {
		sessionFactory.getCurrentSession().save(skill);
		return true;
	}

	@Override
	public boolean insertInSkillRelation(EmployeeSkills skills) {
		sessionFactory.getCurrentSession().save(skills);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Skill getSkillByName(String name) {
		TypedQuery<Skill> query = sessionFactory.getCurrentSession()
				.createQuery(SQL_FIND_SKILL_BY_NAME);
		query.setParameter("skillName", name);
		return query.getSingleResult();
	}

}
