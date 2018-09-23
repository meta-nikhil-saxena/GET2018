package com.metacube.training.EAD_EmployeePortal.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.metacube.training.EAD_EmployeePortal.models.Project;
import com.metacube.training.EAD_EmployeePortal.services.EmployeeService;
import com.metacube.training.EAD_EmployeePortal.services.ProjectService;
import com.metacube.training.EAD_EmployeePortal.services.SearchService;

@Controller
public class HomeController {

	@Autowired
	private SearchService searchService;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private ProjectService projectService;

	@RequestMapping(value = "/")
	public String home() {
		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/error" , method = RequestMethod.GET)
	public String errorPage(){
		return "error";
	}
	
	@RequestMapping(value = "/default", method = RequestMethod.GET)
	public String afterLogin(HttpServletRequest request) {
		if (request.isUserInRole("ROLE_ADMIN")) {
			return "redirect:/admin/security";
		}
		return "redirect:/error";
	}

	@RequestMapping(value = "/searchEmp", method = RequestMethod.GET)
	public String search() {
		return "searchEmp";
	}

	@RequestMapping(value = "/searchByProject", method = RequestMethod.POST)
	public String searchByProject(Model model,
			@RequestParam("search") String name) {

		Project project = projectService.getByName(name);
		int projectId = project.getId();

		model.addAttribute("searchemp",
				employeeService.getByProjectId(projectId));

		return "search";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchEmp(Model model, @RequestParam("search") String name) {
		model.addAttribute("searchemp", searchService.search(name));
		return "search";
	}
}
