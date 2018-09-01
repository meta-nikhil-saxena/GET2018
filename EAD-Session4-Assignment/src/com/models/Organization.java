package com.models;

public class Organization extends BaseEntity{
     
	private String name;

	//Constructor to initialize name
	public Organization(String name,int id){
		this.name = name;
		this.id = id;
	}
	
	//GETTER
	public String getName() {
		return name;
	}        
}
