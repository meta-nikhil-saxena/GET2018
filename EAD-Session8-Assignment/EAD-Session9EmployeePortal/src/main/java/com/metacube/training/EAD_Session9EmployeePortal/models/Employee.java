package com.metacube.training.EAD_Session9EmployeePortal.models;

import java.sql.Date;

public class Employee {
	private int id;
	private String profileImage;
	private String employee_id;
	private String firstname;
	private String lastname;
	private String skills;
	private String gender;
	private String email;
	private String password;
	private String primarycontact;
	private String secondarycontact;
	private Date dob;

	// Getters and Setters

	public String getProfileImage() {
		return profileImage;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrimarycontact() {
		return primarycontact;
	}

	public void setPrimarycontact(String primarycontact) {
		this.primarycontact = primarycontact;
	}

	public String getSecondarycontact() {
		return secondarycontact;
	}

	public void setSecondarycontact(String secondarycontact) {
		this.secondarycontact = secondarycontact;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
	// Getters and Setters End
}
