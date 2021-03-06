package com.metacube.training.EAD_EmployeePortal.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.metacube.training.EAD_EmployeePortal.models.Employee;
import com.metacube.training.EAD_EmployeePortal.services.EmployeeService;
import com.metacube.training.EAD_EmployeePortal.services.SkillService;

//Employee controller 

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private SkillService skillService;
	
	// @Autowired
	// private EmailService emailService;

	// GET and POST method for login Employee
	// @RequestMapping(value = "/login", method = RequestMethod.GET)
	// public ModelAndView login() {
	// return new ModelAndView("employee/login");
	// }
	//
	// @RequestMapping(value = "/login", method = RequestMethod.POST)
	// public ModelAndView employeeHome(Model model,
	// @RequestParam("email") String email,
	// @RequestParam("password") String password) {
	//
	// boolean status = employeeService.checkByEmailAndPassword(email,
	// password);
	//
	// System.out.println(status);
	// if (status) {
	// model.addAttribute("email", email);
	// return new ModelAndView("employee/dashboard");
	// }
	// return new ModelAndView("employee/login");
	// }

	@RequestMapping(value = "/security", method = RequestMethod.GET)
	public String loginSecurity(Principal principal,Model model) {
		model.addAttribute("email", principal.getName());
		return "employee/dashboard";
	}
	
	@RequestMapping(value = "/employeeDashboard", method = RequestMethod.GET)
	public String employeeShow(Model model, @RequestParam("email") String email) {
		Employee employee = employeeService.getEmployeeByName(email);
		model.addAttribute("employee", employee);
		model.addAttribute("skillsList", skillService.getAllSkill());
		return "employee/editEmployee";
	}

	// GET and POST method END

	@RequestMapping(value = "/updatepassword", method = RequestMethod.POST)
	public String updatePassword(@RequestParam("email") String email) {
		// Employee employee = employeeService.getEmployeeByName(email);
		/*
		 * User user = new User();
		 * 
		 * user.setEmailAddress(employee.getEmail());
		 * user.setFirstName(employee.getFirstName());
		 * user.setLastname(employee.getLastname());
		 * user.setPassword(employee.getPassword());
		 * System.out.println(employee.getPassword());
		 * emailService.sendEmail(user);
		 */
		return "employee/login";
	}

	@RequestMapping(value = "/forgotpassword", method = RequestMethod.GET)
	public String forgotPassword() {
		return "employee/forgotpassword";
	}
}
