package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enums.Status;
import com.facade.UserFacade;
import com.models.User;

@SuppressWarnings("serial")
public class SignupController extends HttpServlet {
	UserFacade userfacade = UserFacade.getInstance();

	/**
	 * Services method to process request from jsp page
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		UserFacade userfacade = UserFacade.getInstance();

		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		long contact = Long.parseLong(request.getParameter("contact"));
		String address = request.getParameter("address");
		String city = request.getParameter("cities");
		String company = request.getParameter("company");
		String profileImage = request.getParameter("Upload");

		// User Object to initialize the values in User object
		User user = new User(firstname, lastname, profileImage, contact,
				password, email, address, company, city);

		// Creating user id and inserting in database
		Status status = userfacade.insertStatus(user);
		if (status.equals(Status.CREATED)) {

			String messageToDisplay = "!! PROFILE CREATED !!";

			request.setAttribute("message", messageToDisplay);

			RequestDispatcher requestdispatch = request
					.getRequestDispatcher("index.jsp");

			requestdispatch.forward(request, response);
		}else{
			String messageToDisplay = "!! Duplicate Entry !!";
			
			request.setAttribute("message", messageToDisplay);

			RequestDispatcher requestdispatch = request
					.getRequestDispatcher("index.jsp");

			requestdispatch.forward(request, response);
		}
		out.close();
	}
}
