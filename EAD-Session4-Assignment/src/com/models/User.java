package com.models;

public class User extends BaseEntity {

	private String firstName;
	private String lasttName;
	private String profileImage;
	private long contact;
	private String password;
	private String email;
	private String address;
	private String company;
	private String city;
	private String path = "D:\\GET2018\\EAD\\EAD-Session4-Assignment\\WebContent\\images\\";

	// Constructor to initialize the values
	public User(String firstName, String lasttName, String profile_Image,
			long contact, String password, String email, String address,
			String company, String city) {

		this.firstName = firstName;
		this.lasttName = lasttName;

		if (profile_Image.length() > path.length()) {
			this.profileImage = profile_Image;
		} else {
			this.profileImage = path + profile_Image;
		}

		this.contact = contact;
		this.password = password;
		this.email = email;
		this.address = address;
		this.company = company;
		this.city = city;

	}

	// Getters START
	public String getFirstName() {
		return firstName;
	}

	public String getLasttName() {
		return lasttName;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public long getContact() {
		return contact;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public String getCompany() {
		return company;
	}

	public String getCity() {
		return city;
	}

	// Getters END

}
