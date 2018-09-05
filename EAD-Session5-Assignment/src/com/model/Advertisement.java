package com.model;

public class Advertisement extends BaseEntity {

	private int category_id;
	private String title;

	// Constructor to initialize the attributes
	public Advertisement(int category_id, String title) {
		this.category_id = category_id;
		this.title = title;
	}

	// START Getter
	public int getCategory_id() {
		return category_id;
	}

	public String getTitle() {
		return title;
	}
	// END Getter

}
