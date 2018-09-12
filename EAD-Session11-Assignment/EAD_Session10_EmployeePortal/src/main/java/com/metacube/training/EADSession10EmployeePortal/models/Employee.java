package com.metacube.training.EADSession10EmployeePortal.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "profileImage")
	private String profileImage;

	@Column(name = "employee_id")
	private String employee_id;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "skills")
	private String skills;

	@Column(name = "gender")
	private String gender;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "dob")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dob;

	@Column(name = "primarycontact")
	private String primarycontact;

	@Column(name = "secondarycontact")
	private String secondarycontact;

	@Column(name = "status")
	private boolean status;

	// Getters and Setters

	public String getProfileImage() {
		return profileImage;
	}

	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
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

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
