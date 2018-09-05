package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Class to execute queries used for category table
public class MYSQLCategory implements Category {

	public static MYSQLCategory category = new MYSQLCategory();
	Connection connection;

	public static MYSQLCategory getInstance() {
		return category;
	}

	@Override
	public List<com.model.Category> getlist() {
		List<com.model.Category> listOfCategory = new ArrayList<com.model.Category>();

		String selectQuery = "SELECT * FROM category";

		connection = ConnectionFactory.getConnection();

		try {
			PreparedStatement statement = connection
					.prepareStatement(selectQuery);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");

				com.model.Category category = new com.model.Category(name);
				category.setId(id);

				listOfCategory.add(category);
			}

			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listOfCategory;
	}

	@Override
	public void insert(com.model.Category t) {
		String insertQuery = "INSERT INTO category(name)VALUES(?) ";
		connection = ConnectionFactory.getConnection();

		try {
			PreparedStatement statement = connection
					.prepareStatement(insertQuery);

			statement.setString(1, t.getName());

			statement.executeUpdate();

			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(com.model.Category t) {
		String updateQeury = "UPDATE category SET name=? WHERE id=? ";

		connection = ConnectionFactory.getConnection();

		try {
			PreparedStatement statement = connection
					.prepareStatement(updateQeury);

			statement.setString(1, t.getName());
			statement.setInt(2, t.getId());

			statement.executeUpdate();

			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void delete(com.model.Category t) {
		// code for delete by any attribute
	}

	@Override
	public boolean CheckCategory(String name) {
		boolean status = false;
		String checkEmailQuery = "SELECT * FROM category WHERE name = '" + name
				+ "'";

		connection = ConnectionFactory.getConnection();
		try {
			PreparedStatement statement = connection
					.prepareStatement(checkEmailQuery);

			ResultSet result = statement.executeQuery();

			if (result.next()) {
				status = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public void deleteById(int id) {
		String deleteQuery = "DELETE FROM category WHERE id='"+id+"' ";

		connection = ConnectionFactory.getConnection();
		
		try {
			PreparedStatement statement = connection.prepareStatement(deleteQuery);
			
			statement.executeUpdate();
			
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
