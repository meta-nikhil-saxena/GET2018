package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ConnectionFactory;
import com.dao.Queries;

@SuppressWarnings("serial")
public class SearchEmp extends HttpServlet {
	/**
	 * Method to perform request and responses from Page
	 * 
	 * @param request
	 * @param response
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// Getting data from HTML page
		String firstname = request.getParameter("searchfirstname");
		String lastname = request.getParameter("searchlastname");

		try {
			Connection connection = ConnectionFactory.getConnection();
			PreparedStatement statement = connection
					.prepareStatement(Queries.searchQuery);

			statement.setString(1, firstname);
			statement.setString(2, lastname);

			ResultSet result = statement.executeQuery();

			out.print("<h1 align='center'>Search Employee</h1><br>");
			out.print("<table align='center' border=1 cellpadding=10 cellspacing=5>");

			// Getting column name
			ResultSetMetaData rsmd = result.getMetaData();
			int total = rsmd.getColumnCount();

			out.print("<tr>");

			for (int i = 1; i <= total; i++) {
				out.print(" <th> " + rsmd.getColumnName(i) + " </th> ");
			}

			out.print("</tr>");

			// Getting Rows
			while (result.next()) {

				out.print("<tr><td>" + result.getString(1) + "</td><td>"
						+ result.getString(2) + "</td><td>"
						+ result.getString(3) + "</td><td>"
						+ result.getString(4) + "</td><td>"
						+ result.getString(5) + "</td></tr>");

			}

			out.print("</table>");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
