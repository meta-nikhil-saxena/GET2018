package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.facade.OrganizationFacade;
import com.models.Organization;
import com.models.User;
import com.view.Friend;

//Class for Operation on User Entity
public class MYSQLUserDao implements UserDao {

	static MYSQLUserDao mysqlobj = new MYSQLUserDao();
	Connection connection;

	private MYSQLUserDao() {
	}

	// Singleton object for User Dao Operations
	public static MYSQLUserDao getInstance() {
		return mysqlobj;
	}

	/**
	 * Function to insert data in database
	 * 
	 * @param user
	 */
	@Override
	public void insert(User t) {
		OrganizationFacade organization = OrganizationFacade.getInstance();
		List<Organization> listOfOrganization = organization
				.getListOfOrganization();
		String insertQuery = "INSERT INTO user(organization_id,first_name,last_name,profile_image,email,password,city,contact_number,address)VALUES(?,?,?,?,?,?,?,?,?)";

		connection = ConnectionFactory.getConnection();

		try {

			PreparedStatement statement = connection
					.prepareStatement(insertQuery);

			for (Organization list : listOfOrganization) {
				if (t.getCompany().equals(list.getName())) {
					statement.setInt(1, list.getId());
				}
			}

			statement.setString(2, t.getFirstName());
			statement.setString(3, t.getLasttName());
			statement.setString(4, t.getProfileImage());
			statement.setString(5, t.getEmail());
			statement.setString(6, t.getPassword());
			statement.setString(7, t.getCity());
			statement.setLong(8, t.getContact());
			statement.setString(9, t.getAddress());

			statement.executeUpdate();

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void delete(User t) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean CheckUserByEmail(String email) {
		boolean status = false;
		String checkEmailQuery = "SELECT * FROM user WHERE email = '" + email
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

	/**
	 * Function to display list of friends from database
	 * 
	 * @param email
	 * @return listOfFriend
	 */
	@Override
	public List<Friend> displayFriendList(String email) {

		List<Friend> listOfFriend = new ArrayList<Friend>();
		OrganizationFacade organization = OrganizationFacade.getInstance();
		List<Organization> listOfOrganization = organization
				.getListOfOrganization();
		User user = this.getUserData(email);

		String selectQuery = "SELECT * FROM user WHERE organization_id=? "
				+ " AND email NOT IN(SELECT email FROM user WHERE email='"
				+ email + "')";

		connection = ConnectionFactory.getConnection();

		try {
			PreparedStatement statement = connection
					.prepareStatement(selectQuery);

			for (Organization list : listOfOrganization) {
				if (list.getName().equals(user.getCompany())) {
					statement.setInt(1, list.getId());
				}
			}

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				String firstname = result.getString("first_name");
				String lastname = result.getString("last_name");
				String profileImage = result.getString("profile_image");
				String address = result.getString("address");
				long contact = result.getLong("contact_number");
				int id = result.getInt("organization_id");
                String emailfriend = result.getString("email");
				
				String company = null;
				for (Organization list : listOfOrganization) {
					if (list.getId() == id) {
						company = list.getName();
					}
				}
				Friend friend = new Friend(firstname, lastname, profileImage,
						address, contact, company,emailfriend);

				listOfFriend.add(friend);
			}

			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listOfFriend;
	}

	/**
	 * Function to check email and password
	 * 
	 * @param email
	 * @param password
	 * @return status
	 */
	@Override
	public boolean CheckUserByEmailAndPassword(String email, String password) {
		boolean status = false;

		String checkEmailQuery = "SELECT * FROM user WHERE email = '" + email
				+ "' AND password = '" + password + "'";

		connection = ConnectionFactory.getConnection();

		try {
			PreparedStatement statement = connection
					.prepareStatement(checkEmailQuery);

			ResultSet result = statement.executeQuery();

			if (result.next()) {
				status = true;
			}

			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return status;
	}

	/**
	 * Function to get User Data by Email
	 * 
	 * @param email
	 * @return User object
	 */
	@Override
	public User getUserData(String email) {

		OrganizationFacade organizationfacade = OrganizationFacade
				.getInstance();

		User user = null;

		List<Organization> listOfOrganization = organizationfacade
				.getListOfOrganization();

		String selectQuery = "SELECT * FROM user WHERE email = '" + email + "'";

		connection = ConnectionFactory.getConnection();

		try {
			PreparedStatement statement = connection
					.prepareStatement(selectQuery);

			ResultSet result = statement.executeQuery();

			if (result.next()) {
				String firstname = result.getString("first_name");
				String lastname = result.getString("last_name");
				String profileImage = result.getString("profile_image");
				long contact = result.getLong("contact_number");
				String password = result.getString("password");
				String emailid = result.getString("email");
				String address = result.getString("address");
				String company = null;
				for (Organization organization : listOfOrganization) {
					if (organization.getId() == result
							.getInt("organization_id")) {

						company = organization.getName();
					}
				}

				String city = result.getString("city");

				user = new User(firstname, lastname, profileImage, contact,
						password, emailid, address, company, city);
			}

			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public List<User> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(User t) {

		OrganizationFacade organization = OrganizationFacade.getInstance();
		List<Organization> listOfOrganization = organization
				.getListOfOrganization();
		com.view.User userview = new com.view.User(t.getFirstName(),
				t.getLasttName(), t.getProfileImage(), t.getAddress(),
				t.getContact(), t.getCompany(), t.getEmail());

		String updateQuery = "UPDATE user SET organization_id=? , first_name=? , last_name=? , profile_image=? , address=? , contact_number=? WHERE email=? ";

		connection = ConnectionFactory.getConnection();

		try {
			PreparedStatement statement = connection
					.prepareStatement(updateQuery);

			for (Organization organizationlist : listOfOrganization) {
				if (userview.getCompany().equals(organizationlist.getName())) {
					statement.setInt(1, organizationlist.getId());
				}
			}

			statement.setString(2, userview.getFirstName());
			statement.setString(3, userview.getLastName());
			statement.setString(4, userview.getProfileImage());
			statement.setString(5, userview.getAddress());
			statement.setLong(6, userview.getContact());
			statement.setString(7, userview.getEmail());

			statement.executeUpdate();

			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
