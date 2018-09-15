package com.metacube.training.EADSession10EmployeePortal.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.EADSession10EmployeePortal.models.Skill;

public class SkillMapper implements RowMapper<Skill> {

	@Override
	public Skill mapRow(ResultSet rs, int rowNum) throws SQLException {
		Skill skill = new Skill();
		skill.setId(rs.getInt("id"));
		skill.setTitle(rs.getString("title"));
		return skill;
	}

}
