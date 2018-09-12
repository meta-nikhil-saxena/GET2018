package com.metacube.training.EADSession10EmployeePortal.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metacube.training.EADSession10EmployeePortal.models.Project;

@Repository
@Transactional
public class ProjectDAOImpl implements ProjectDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private final String SQL_FIND_PROJECT = "from Project where id = :projectId";
	private final String SQL_DELETE_PROJECT = "delete from Project where id = :projectId";
	private final String SQL_UPDATE_PROJECT = "update Project set name=:name,project_logo =:logo, description = :description, start_date  =  :startDate, end_date  = :endDate where id = :projectId";
	private final String SQL_GET_ALL = "from Project";

	@SuppressWarnings("unchecked")
	public Project getProjectById(int id) {
		TypedQuery<Project> query = sessionFactory.getCurrentSession()
				.createQuery(SQL_FIND_PROJECT);
		query.setParameter("projectId", id);
		return query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<Project> getAllProjects() {
		TypedQuery<Project> query = sessionFactory.getCurrentSession()
				.createQuery(SQL_GET_ALL);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public boolean deleteProject(Project person) {
		TypedQuery<Project> query = sessionFactory.getCurrentSession()
				.createQuery(SQL_DELETE_PROJECT);
		query.setParameter("projectId", person.getId());
		return (query.executeUpdate() > 0);
	}

	@SuppressWarnings("unchecked")
	public boolean updateProject(Project person) {

		TypedQuery<Project> query = sessionFactory.getCurrentSession()
				.createQuery(SQL_UPDATE_PROJECT);

		query.setParameter("description", person.getDescription());
		query.setParameter("startDate", person.getStartDate());
		query.setParameter("endDate", person.getEndDate());
		query.setParameter("name", person.getProjectName());
		query.setParameter("logo", person.getLogo());
		query.setParameter("projectId", person.getId());

		return (query.executeUpdate() > 0);
	}

	public boolean createProject(Project person) {
		sessionFactory.getCurrentSession().save(person);
		return true;
	}
}