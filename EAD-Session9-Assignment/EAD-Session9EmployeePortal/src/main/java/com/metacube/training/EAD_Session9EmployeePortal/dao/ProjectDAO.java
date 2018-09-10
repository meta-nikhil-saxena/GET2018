package com.metacube.training.EAD_Session9EmployeePortal.dao;

import java.util.List;

import com.metacube.training.EAD_Session9EmployeePortal.models.Project;

public interface ProjectDAO {

	Project getProjectById(int id);

	List<Project> getAllProjects();

	boolean deleteProject(Project project);

	boolean updateProject(Project project);

	boolean createProject(Project project);

}
