package com.metacube.training.EAD_Session9EmployeePortal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//Employee controller 

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	// GET and POST method for login Employee
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		return new ModelAndView("employee/login");
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView employeeHome() {
		return new ModelAndView("employee/dashboard");
	}

	// GET and POST method END
}
