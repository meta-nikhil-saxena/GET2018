package com.metacube.training.EAD_Session9EmployeePortal.services;

import java.util.List;

import com.metacube.training.EAD_Session9EmployeePortal.models.Project;

public interface ProjectService {

	Project getProjectById(int id);

	List<Project> getAllProjects();

	boolean deleteProject(int id);

	boolean updateProject(Project project);

	boolean createProject(Project project);

}
