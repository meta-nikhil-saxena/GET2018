package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.ConnectionFactory;
import com.dao.Queries;

@SuppressWarnings("serial")
public class Update extends HttpServlet {
	/**
	 * Method to perform request and responses from Page
	 * 
	 * @param request
	 * @param response
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Connection connection;
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("employeeid"));

		try {
			connection = ConnectionFactory.getConnection();
			PreparedStatement statement = connection
					.prepareStatement(Queries.selectWithCondition);
			statement.setInt(1, id);

			ResultSet result = statement.executeQuery();

			out.print("<h1 align='center'>Employee Details Update<h1><br>");

			out.print("<table align='center' width=50% border='5px solid' cellpadding=10 cellspacing=10>");

			while (result.next()) {

				out.print("<form action='UpdateDetails'>");

				out.print("<tr>");
				out.print("<th>First Name</th>");
				out.print("<td><input type='text' size='30px' name='firstname' value = '"
						+ result.getString(2) + "'/></td>");
				out.print("</tr>");

				out.print("<tr>");
				out.print("<th>Last Name</th>");
				out.print("<td><input type='text' size='30px' name='lastname' value = '"
						+ result.getString(3) + "'/></td>");
				out.print("</tr>");

				out.print("<tr>");
				out.print("<th>Email</th>");
				out.print("<td><input type='email' size='30px' name='email' value = '"
						+ result.getString(4) + "'/></td>");
				out.print("</tr>");

				out.print("<tr>");
				out.print("<th>Age</th>");
				out.print("<td><input type='text' size='30px' name='age' value = '"
						+ result.getString(5) + "'/></td>");
				out.print("</tr>");

				out.print("<tr>");
				out.print("<td><input type='submit' size='30px' value = 'Update'/></td>");
				out.print("<td><input type='reset' size='30px' value = 'Reset'/></td>");
				out.print("</tr>");

				out.print("</form>");

			}
			out.print("</table>");
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		out.close();
	}
}
