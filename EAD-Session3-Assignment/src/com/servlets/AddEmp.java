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
import com.dao.Employee;
import com.dao.Queries;

/**
 * Servlet implementation class AddEmp
 */

@SuppressWarnings("serial")
public class AddEmp extends HttpServlet {
	/**
	 * Method to perform request and responses from Page
	 * 
	 * @param request
	 * @param response
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");

		Connection connection;
		Employee employee;
		int result = 0;

		// Getting data from text field from HTML page
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		int age = Integer.parseInt(request.getParameter("age"));

		PrintWriter out = response.getWriter();

		System.out.println(firstname);
		System.out.println(lastname);
		System.out.println(email);
		System.out.println(age);

		// storing data in employee object
		employee = new Employee(firstname, lastname, email, age);

		try {
			connection = ConnectionFactory.getConnection();

			PreparedStatement statement = connection
					.prepareStatement(Queries.insertQuery);

			statement.setString(1, employee.getFirstName());
			statement.setString(2, employee.getLastName());
			statement.setString(3, employee.getEmail());
			statement.setInt(4, employee.getAge());

			result = statement.executeUpdate();

			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		if (result > 0) {
			// out.println("Employee Successfully Added !!");

			RequestDispatcher requestdispatch = request
					.getRequestDispatcher("index.html");

			requestdispatch.forward(request, response);

		} else {
			out.println("!! ERROR !!");
		}

		out.close();
	}
}
