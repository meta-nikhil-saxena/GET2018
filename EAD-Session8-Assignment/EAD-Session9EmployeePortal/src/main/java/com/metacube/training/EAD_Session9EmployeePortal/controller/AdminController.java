package com.metacube.training.EAD_Session9EmployeePortal.controller;
import com.metacube.training.EAD_Session9EmployeePortal.services.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;




//Admin Controller

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ProjectService projectService;
	
	// Login Methods GET and POST
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		return new ModelAndView("admin/login");
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView dashboard() {
		return new ModelAndView("admin/dashboard");
	}

	// GET and POST Login method END

	// Add Employee Function
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public ModelAndView Employee() {
		return new ModelAndView("admin/employee");
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
	public ModelAndView addEmployee() {
		return new ModelAndView("admin/editEmployee");
	}
	
	@RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
	public ModelAndView editEmployee() {
		return new ModelAndView("admin/editEmployee");
	}

	
	// Add Project Function
	
	@RequestMapping(path = "saveproject", method = RequestMethod.POST)
	public String saveproject(@ModelAttribute("project") com.metacube.training.EAD_Session9EmployeePortal.models.Project project) {
		if (project != null && project.getId() == 0) {
			projectService.createProject(project);
		} else {
			projectService.updateProject(project);
		}
		return "redirect:/admin/projects";
	}
	
	@RequestMapping(value = "/project", method = RequestMethod.GET)
	public String Project(Model model) {
		model.addAttribute("projects", projectService.getAllProjects());
		return "admin/project";
	}

	@RequestMapping(value = "/addProject", method = RequestMethod.GET)
	public String addProject(Model model) {
		
		return "admin/editproject";
	}

	@RequestMapping(value = "/editProject", method = RequestMethod.GET)
	public String editProject(Model model,@RequestParam("id") int id) {
		model.addAttribute("projects",projectService.getProjectById(id));
		return "admin/editproject";
	}

	// Add Job Function
	@RequestMapping(value = "/job", method = RequestMethod.GET)
	public ModelAndView job() {
		return new ModelAndView("admin/job");
	}

	@RequestMapping(value = "/addJob", method = RequestMethod.GET)
	public ModelAndView addJob() {
		return new ModelAndView("admin/editjob");
	}

	@RequestMapping(value = "/editJob", method = RequestMethod.GET)
	public ModelAndView editJob() {
		return new ModelAndView("admin/editjob");
	}

	// Add Skill Function
	@RequestMapping(value = "/skills", method = RequestMethod.GET)
	public ModelAndView skill() {
		return new ModelAndView("admin/skills");
	}

	@RequestMapping(value = "/addSkills", method = RequestMethod.GET)
	public ModelAndView addSkills() {
		return new ModelAndView("admin/editskills");
	}

	@RequestMapping(value = "/editSkills", method = RequestMethod.GET)
	public ModelAndView editSkills() {
		return new ModelAndView("admin/editskills");
	}
}
