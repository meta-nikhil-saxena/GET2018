package com.dao;

//Queries used by database
public class Queries {

	public static final String insertQuery = "INSERT INTO add_employee(first_name,last_name,email,age)VALUES"
			+ " (?,?,?,?) ";

	public static final String selectQuery = " SELECT * FROM add_employee ";

	public static final String searchQuery = "SELECT * FROM add_employee"
			+ " WHERE first_name = ? " + " AND last_name = ? ";

	public static final String selectWithCondition = "SELECT * FROM add_employee"
			+ " WHERE id = ? ";

	public static final String updateQuery = "UPDATE add_employee "
			+ " SET first_name = ?,last_name = ?,email = ?, age= ?"
			+ " WHERE email = ?";

}
