package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.facade.CategoryFacade;
import com.view.AdvertisementView;

public class MYSQLAdvertisement implements Advertisement {

	public static MYSQLAdvertisement advertisement = new MYSQLAdvertisement();

	CategoryFacade categoryfacade = CategoryFacade.getInstance();

	public static MYSQLAdvertisement getInstance() {
		return advertisement;
	}

	Connection connection;

	@Override
	public List<com.model.Advertisement> getlist() {
		List<com.model.Advertisement> listOfAdvertisement = new ArrayList<com.model.Advertisement>();

		String selectQuery = "SELECT * FROM advertisement";

		connection = ConnectionFactory.getConnection();

		try {
			PreparedStatement statement = connection
					.prepareStatement(selectQuery);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				int category_id = resultSet.getInt("category_id");
				String name = resultSet.getString("advertisement_title");

				com.model.Advertisement advertisement = new com.model.Advertisement(
						category_id, name);
				advertisement.setId(id);

				listOfAdvertisement.add(advertisement);
			}

			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listOfAdvertisement;
	}

	@Override
	public void insert(com.model.Advertisement t) {
		String insertQuery = "INSERT INTO advertisement(category_id,advertisement_title)VALUES(?,?) ";

		connection = ConnectionFactory.getConnection();

		try {
			PreparedStatement statement = connection
					.prepareStatement(insertQuery);

			statement.setInt(1, t.getCategory_id());

			statement.setString(2, t.getTitle());

			statement.executeUpdate();

			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void update(com.model.Advertisement t) {
		String updateQeury = "UPDATE advertisement SET name=? WHERE name='"
				+ t.getTitle() + "' ";

		connection = ConnectionFactory.getConnection();

		try {
			PreparedStatement statement = connection
					.prepareStatement(updateQeury);

			statement.setString(1, t.getTitle());

			statement.executeUpdate();

			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void delete(com.model.Advertisement t) {
		// code for delete will come here with any attribute
	}

	@Override
	public boolean CheckAdvertisement(String name) {
		boolean status = false;
		String checkQuery = "SELECT * FROM advertisement WHERE  advertisement_title = '"
				+ name + "'";

		connection = ConnectionFactory.getConnection();
		try {
			PreparedStatement statement = connection
					.prepareStatement(checkQuery);

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
	public List<AdvertisementView> getListById(int category_id) {
		List<AdvertisementView> listOfAdvertisement = new ArrayList<>();
		String selectQuery = "SELECT advertisement_title FROM advertisement WHERE category_id = '"
				+ category_id + "'";

		connection = ConnectionFactory.getConnection();

		try {
			PreparedStatement statement = connection
					.prepareStatement(selectQuery);

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				String name = result.getString("advertisement_title");

				AdvertisementView advertisement = new AdvertisementView(name);

				listOfAdvertisement.add(advertisement);
			}

			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listOfAdvertisement;
	}

	@Override
	public void deleteById(int id) {
		String deleteQuery = "DELETE FROM advertisement WHERE id='"+id+"' ";

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
