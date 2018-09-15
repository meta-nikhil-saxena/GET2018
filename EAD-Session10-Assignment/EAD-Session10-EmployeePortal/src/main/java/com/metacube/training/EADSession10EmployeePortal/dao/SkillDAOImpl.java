package com.metacube.training.EADSession10EmployeePortal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.EADSession10EmployeePortal.mapper.SkillMapper;
import com.metacube.training.EADSession10EmployeePortal.models.Skill;

@Repository
public class SkillDAOImpl implements SkillDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public SkillDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private final String SQL_FIND_SKILL = "select * from skill_master where id = ?";
	private final String SQL_DELETE_SKILL = "delete from skill_master where id = ?";
	private final String SQL_UPDATE_SKILL = "update skill_master set title= ? WHERE id=?";
	private final String SQL_GET_ALL = "select * from skill_master";
	private final String SQL_INSERT_SKILL = "insert into skill_master(title) values(?)";

	@Override
	public Skill getSkillById(int id) {
		return jdbcTemplate.queryForObject(SQL_FIND_SKILL, new Object[] { id },
				new SkillMapper());
	}

	@Override
	public List<Skill> getAllSkill() {
		return jdbcTemplate.query(SQL_GET_ALL, new SkillMapper());
	}

	@Override
	public boolean deleteSkill(Skill skill) {
		return jdbcTemplate.update(SQL_DELETE_SKILL, skill.getId()) > 0;
	}

	@Override
	public boolean updateSkill(Skill skill) {
		return jdbcTemplate.update(SQL_UPDATE_SKILL, skill.getTitle(),
				skill.getId()) > 0;
	}

	@Override
	public boolean createSkill(Skill skill) {
		return jdbcTemplate.update(SQL_INSERT_SKILL, skill.getTitle()) > 0;
	}

}
