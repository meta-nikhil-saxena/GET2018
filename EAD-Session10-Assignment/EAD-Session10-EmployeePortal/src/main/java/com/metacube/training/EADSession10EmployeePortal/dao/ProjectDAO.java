package com.metacube.training.EADSession10EmployeePortal.dao;

import java.util.List;

import com.metacube.training.EADSession10EmployeePortal.models.Project;

public interface ProjectDAO {

	Project getProjectById(int id);

	List<Project> getAllProjects();

	boolean deleteProject(Project project);

	boolean updateProject(Project project);

	boolean createProject(Project project);

}
