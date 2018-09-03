package com.view;

public class Friend {

	private String firstName;
	private String lastName;
	private String profileImage;
	private String address;
	private long contact;
	private String company;
	private String email;

	// Constructor to initialize the values
	public Friend(String firstName, String lastName, String profileImage,
			String address, long contact, String company, String email) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.profileImage = profileImage;
		this.address = address;
		this.contact = contact;
		this.company = company;
		this.email = email;
	}

	// Getter START
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public String getAddress() {
		return address;
	}

	public long getContact() {
		return contact;
	}

	public String getCompany() {
		return company;
	}

	public String getEmail() {
		return email;
	}

	// Getter END

}
