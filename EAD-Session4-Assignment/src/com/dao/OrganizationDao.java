package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.models.Organization;

public class OrganizationDao implements BaseDao<Organization> {
	public static OrganizationDao organization = new OrganizationDao();
	Connection connection;

	public static OrganizationDao getInstance() {
		return organization;
	}

	public List<Organization> getList() {
		List<Organization> listOfOrganization = new ArrayList<Organization>();

		String selectQuery = "SELECT * FROM organization";

		try {

			connection = ConnectionFactory.getConnection();

			PreparedStatement statement = connection
					.prepareStatement(selectQuery);

			ResultSet result = statement.executeQuery();

			while (result.next()) {

				Organization organization = new Organization(
						result.getString("name"), result.getInt("id"));

				listOfOrganization.add(organization);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listOfOrganization;
	}

	@Override
	public void insert(Organization t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Organization t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Organization t) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Organization> getList(String email) {
		// TODO Auto-generated method stub
		return null;
	}
}
