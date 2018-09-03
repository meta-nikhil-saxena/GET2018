package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	/**
	 * Function to get database connection
	 * 
	 * @return connection object
	 */
	public static Connection getConnection() {

		Connection connection = null;
		String url = "jdbc:mysql://localhost:3306/connection";
		String username = "root";
		String password = "root";
		String driver = "com.mysql.jdbc.Driver";

		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
