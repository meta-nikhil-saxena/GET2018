package com.metacube.training.EAD_EmployeePortal.controller;

import com.metacube.training.EAD_EmployeePortal.models.Employee;
import com.metacube.training.EAD_EmployeePortal.models.EmployeeSkills;
import com.metacube.training.EAD_EmployeePortal.models.Job;
import com.metacube.training.EAD_EmployeePortal.models.JobDetails;
import com.metacube.training.EAD_EmployeePortal.models.Project;
import com.metacube.training.EAD_EmployeePortal.models.Skill;
import com.metacube.training.EAD_EmployeePortal.services.EmployeeService;
import com.metacube.training.EAD_EmployeePortal.services.JobDetailsService;
import com.metacube.training.EAD_EmployeePortal.services.JobService;
import com.metacube.training.EAD_EmployeePortal.services.ProjectService;
import com.metacube.training.EAD_EmployeePortal.services.SkillService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//Admin Controller

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ProjectService projectService;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private JobService jobService;

	@Autowired
	private SkillService skillService;

	@Autowired
	private JobDetailsService jobDetailsService;

	// Login Methods GET and POST
	// @RequestMapping(value = "/login", method = RequestMethod.GET)
	// public ModelAndView login() {
	// return new ModelAndView("admin/login");
	// }
	//
	// @RequestMapping(value = "/login", method = RequestMethod.POST)
	// public ModelAndView dashboard(@RequestParam("email") String email,
	// @RequestParam("password") String password) {
	//
	// if ("admin@gmail.com".equalsIgnoreCase(email)
	// && "admin".equalsIgnoreCase(password)) {
	// return new ModelAndView("admin/dashboard");
	// }
	// return new ModelAndView("admin/login");
	// }

	@RequestMapping(value = "/security", method = RequestMethod.GET)
	public String loginSecurity() {
		return "admin/dashboard";
	}

	// GET and POST Login method END

	// Add Employee Function
	@RequestMapping(path = "/saveemployee", method = RequestMethod.POST)
	public String saveproject(
			@ModelAttribute("employee") Employee employee,
			@RequestParam(value = "skills", required = false) String[] skills,
			@RequestParam(value = "jobs", required = false) String jobid,
			@RequestParam(value = "reporting_manager", required = false) String managerid,
			@RequestParam(value = "teamlead", required = false) String employeeTeamleadId,
			@RequestParam(value = "project", required = false) String projectid) {

		if (employee != null && employee.getId() == 0) {

			String employeeId = "E18/" + employee.getFirstName() + "/"
					+ employee.getLastname();

			employee.setEmployee_id(employeeId);

			employeeService.createEmployee(employee);

			System.out.println(employee.getId());

			if (jobid != null && managerid != null
					&& employeeTeamleadId != null && projectid != null
					&& skills.length != 0) {

				Employee employee1 = employeeService.getEmployeeByName(employee
						.getEmail());

				JobDetails jobdetails = new JobDetails();

				jobdetails.setEmployee_id(employee1.getId());
				jobdetails.setJobId(Integer.parseInt(jobid));
				jobdetails.setProjectId(Integer.parseInt(projectid));
				jobdetails.setReportingManager(Integer.parseInt(managerid));
				jobdetails.setTeam_lead(Integer.parseInt(employeeTeamleadId));

				jobDetailsService.insertData(jobdetails);

				// loop to insert in skill relation
				for (int i = 0; i < skills.length; i++) {

					Skill skill = skillService.getSkillById(Integer
							.parseInt(skills[i]));
					EmployeeSkills empSkills = new EmployeeSkills();
					empSkills.setEmployeeId(employee1.getId());
					empSkills.setSkillId(skill.getId());
					skillService.insertInSkillRelation(empSkills);
				}
			}
		} else {
			employeeService.updateEmployee(employee);
		}
		return "redirect:/admin/employee";
	}

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public String employee(Model model) {
		model.addAttribute("employees", employeeService.getAllEmployee());
		return "admin/employee";
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
	public String addEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("skillsList", skillService.getAllSkill());
		model.addAttribute("jobsList", jobService.getAllJobs());
		model.addAttribute("employeeList", employeeService.getAllEmployee());
		model.addAttribute("projectList", projectService.getAllProjects());
		model.addAttribute("skills", new String[10]);
		return "admin/editEmployee";
	}

	@RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
	public String editEmployee(Model model, @RequestParam("id") int id) {
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		model.addAttribute("skillsList", skillService.getAllSkill());
		model.addAttribute("jobsList", jobService.getAllJobs());
		model.addAttribute("employeeList", employeeService.getAllEmployee());
		model.addAttribute("projectList", projectService.getAllProjects());
		return "admin/editEmployee";
	}

	@RequestMapping(value = "/employeeDashboard", method = RequestMethod.GET)
	public String employeeShow(Model model, @RequestParam("email") String email) {
		Employee employee = employeeService.getEmployeeByName(email);
		model.addAttribute("employee", employee);
		model.addAttribute("skillsList", skillService.getAllSkill());
		return "admin/editEmployee";
	}

	@RequestMapping(value = "/deleteEmployee")
	public String deleteEmployee(Model model, @RequestParam("id") int id) {
		employeeService.deleteEmployee(id);
		return "redirect:employee";
	}

	// Add Project Function

	@RequestMapping(path = "/saveproject", method = RequestMethod.POST)
	public String saveproject(@ModelAttribute("project") Project project) {
		if (project != null && project.getId() == 0) {
			projectService.createProject(project);
		} else {
			projectService.updateProject(project);
		}
		return "redirect:/admin/project";
	}

	@RequestMapping(value = "/project", method = RequestMethod.GET)
	public String project(Model model) {
		model.addAttribute("projects", projectService.getAllProjects());
		return "admin/project";
	}

	@RequestMapping(value = "/addProject", method = RequestMethod.GET)
	public String addProject(Model model) {
		model.addAttribute("project", new Project());
		return "admin/editproject";
	}

	@RequestMapping(value = "/editProject", method = RequestMethod.GET)
	public String editProject(Model model, @RequestParam("id") int id) {
		model.addAttribute("project", projectService.getProjectById(id));
		return "admin/editproject";
	}

	@RequestMapping(value = "/deleteProject")
	public String deleteProject(Model model, @RequestParam("id") int id) {
		projectService.deleteProject(id);
		return "redirect:project";
	}

	// Add Job Function
	@RequestMapping(path = "/savejob", method = RequestMethod.POST)
	public String saveproject(@ModelAttribute("job") Job job) {
		if (job != null && job.getId() == 0) {
			jobService.createJob(job);
		} else {
			jobService.updateJob(job);
		}
		return "redirect:/admin/job";
	}

	@RequestMapping(value = "/job", method = RequestMethod.GET)
	public String job(Model model) {
		model.addAttribute("jobs", jobService.getAllJobs());
		return "admin/job";
	}

	@RequestMapping(value = "/addJob", method = RequestMethod.GET)
	public String addJob(Model model) {
		model.addAttribute("job", new Job());
		return "admin/editjob";
	}

	@RequestMapping(value = "/editJob", method = RequestMethod.GET)
	public String editJob(Model model, @RequestParam("id") int id) {
		model.addAttribute("job", jobService.getJobById(id));
		return "admin/editjob";
	}

	@RequestMapping(value = "/deleteJob")
	public String deleteJob(Model model, @RequestParam("id") int id) {
		jobService.deleteJob(id);
		return "redirect:job";
	}

	// Add Skill Function
	@RequestMapping(path = "/saveskill", method = RequestMethod.POST)
	public String saveskill(@ModelAttribute("skill") Skill skill) {
		if (skill != null && skill.getId() == 0) {
			skillService.createSkill(skill);
		} else {
			skillService.updateSkill(skill);
		}
		return "redirect:/admin/skills";
	}

	@RequestMapping(value = "/skills", method = RequestMethod.GET)
	public String skill(Model model) {
		model.addAttribute("skills", skillService.getAllSkill());
		return "admin/skills";
	}

	@RequestMapping(value = "/addSkills", method = RequestMethod.GET)
	public String addSkills(Model model) {
		model.addAttribute("skill", new Skill());
		return "admin/editskills";
	}

	@RequestMapping(value = "/editskills", method = RequestMethod.GET)
	public String editSkill(Model model, @RequestParam("id") int id) {
		model.addAttribute("skill", skillService.getSkillById(id));
		return "admin/editskills";
	}

	@RequestMapping(value = "/deleteSkills")
	public String deleteSkills(Model model, @RequestParam("id") int id) {
		skillService.deleteSkill(id);
		return "redirect:skills";
	}
}
