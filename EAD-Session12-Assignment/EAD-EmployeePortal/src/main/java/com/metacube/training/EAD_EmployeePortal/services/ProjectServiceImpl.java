package com.metacube.training.EAD_EmployeePortal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.EAD_EmployeePortal.models.Project;
import com.metacube.training.EAD_EmployeePortal.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository<Project> projectRepository;

	@Override
	public Project getProjectById(int id) {
		return projectRepository.findOne(id);
	}

	@Override
	public List<Project> getAllProjects() {
		return projectRepository.findAll();
	}

	@Override
	public boolean deleteProject(int id) {
		Project project = projectRepository.findOne(id);
		projectRepository.delete(project);
		return true;
	}

	@Override
	public boolean updateProject(Project project) {
		try {
			projectRepository.save(project);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean createProject(Project project) {
		projectRepository.save(project);
		return true;
	}

	@Override
	public Project getByName(String name) {
		return projectRepository.findByProjectName(name);
	}

}
