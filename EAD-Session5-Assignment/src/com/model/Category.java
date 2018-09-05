package com.model;

public class Category extends BaseEntity {

	private String name;

	//Constructor to initialize attributes
	public Category(String name) {
	
		this.name = name;
		
	}

	// Getter START
	public String getName() {
		return name;
	}
	// Getter END

}
