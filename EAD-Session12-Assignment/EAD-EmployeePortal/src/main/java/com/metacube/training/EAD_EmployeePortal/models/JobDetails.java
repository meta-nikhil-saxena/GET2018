package com.metacube.training.EAD_EmployeePortal.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "job_details")
public class JobDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "employee_id")
	private int employeeId;

	@Column(name = "job_id")
	private int jobId;

	@Column(name = "reporting_manager")
	private int reportingManager;

	@Column(name = "team_lead")
	private int team_lead;

	@Column(name = "project_id")
	private int projectId;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the employee_id
	 */
	public int getEmployee_id() {
		return employeeId;
	}

	/**
	 * @param employee_id
	 *            the employee_id to set
	 */
	public void setEmployee_id(int employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the jobId
	 */
	public int getJobId() {
		return jobId;
	}

	/**
	 * @param jobId
	 *            the jobId to set
	 */
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	/**
	 * @return the reportingManager
	 */
	public int getReportingManager() {
		return reportingManager;
	}

	/**
	 * @param reportingManager
	 *            the reportingManager to set
	 */
	public void setReportingManager(int reportingManager) {
		this.reportingManager = reportingManager;
	}

	/**
	 * @return the team_lead
	 */
	public int getTeam_lead() {
		return team_lead;
	}

	/**
	 * @param team_lead
	 *            the team_lead to set
	 */
	public void setTeam_lead(int team_lead) {
		this.team_lead = team_lead;
	}

	/**
	 * @return the projectId
	 */
	public int getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId
	 *            the projectId to set
	 */
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

}
