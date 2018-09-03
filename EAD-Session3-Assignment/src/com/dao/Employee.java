package com.dao;
//POJO class for storing employee details
public class Employee {
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    
    //Constructor to add employee details
    public Employee(String firstName,String lastName,String email,int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.age = age;
	}
    
    //Getter START
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmail() {
		return email;
	}
	public int getAge() {
		return age;
	}
	//Getter END
}
