package com.metacube.training.EAD_Session9EmployeePortal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.metacube.training.EAD_Session9EmployeePortal.services.SearchService;

@Controller
public class HomeController {

	@Autowired
	private SearchService searchService;

	@RequestMapping(value = "/")
	public String home() {
		return "home";
	}

	@RequestMapping(value = "/searchEmp", method = RequestMethod.GET)
	public String search() {
		return "searchEmp";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchEmp(Model model, @RequestParam("search") String name) {
		model.addAttribute("searchemp", searchService.search(name));
		return "search";
	}
}
