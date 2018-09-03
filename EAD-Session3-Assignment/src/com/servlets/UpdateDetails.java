package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ConnectionFactory;
import com.dao.Queries;

@SuppressWarnings("serial")
public class UpdateDetails extends HttpServlet {

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
		Connection connection;

		// Getting Fields
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		int age = Integer.parseInt(request.getParameter("age"));

		try {
			connection = ConnectionFactory.getConnection();
			PreparedStatement statement = connection
					.prepareStatement(Queries.updateQuery);

			// Setting new fields and checking condition
			statement.setString(1, firstname);
			statement.setString(2, lastname);
			statement.setString(3, email);
			statement.setInt(4, age);
			statement.setString(5, email);

			int update = statement.executeUpdate();

			if (update > 0) {
				out.print("<h1>Fields Updated</h1>");

				RequestDispatcher requestdispatch = request
						.getRequestDispatcher("index.html");
				requestdispatch.forward(request, response);
			} else {
				out.print("!! Same Entry !! Or Invalid fields");
			}

			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		out.close();
	}

}
