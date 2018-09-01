package com.filters;

import java.util.regex.Pattern;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//Class to do validation for sign up page
public class SignupValidationFilter implements javax.servlet.Filter {

	public void doFilter(final ServletRequest request,
			final ServletResponse response, FilterChain chain)
			throws java.io.IOException, javax.servlet.ServletException {

		RequestDispatcher requestdispatch = request
				.getRequestDispatcher("signup.jsp");

		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String password = request.getParameter("password");
		String confirmpassword = request.getParameter("confirmpassword");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");

		if (firstname == null && lastname == null && password == null
				&& confirmpassword == null && email == null && contact == null) {

			String messageToDisplay = "!! ALL Fields Can't be Blank !!";
			request.setAttribute("message", messageToDisplay);
			requestdispatch.forward(request, response);

		} else if (!Pattern.matches("(^[A-Za-z]+$)", firstname)
				|| firstname.length() < 3 || firstname == null) {

			String messageToDisplay = "!! Invalid First name !!";
			request.setAttribute("message", messageToDisplay);
			requestdispatch.forward(request, response);

		} else if (!Pattern.matches("(^[A-Za-z]+$)", lastname)
				|| lastname.length() < 3 || lastname == "") {

			String messageToDisplay = "!! Invalid LastName !!";
			request.setAttribute("message", messageToDisplay);
			requestdispatch.forward(request, response);
		} else if (!Pattern.matches(
				"^(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])(?=.*[a-z]).{8,}$",
				password)
				|| password == "") {

			String messageToDisplay = "!! Invalid Password !!";
			request.setAttribute("message", messageToDisplay);
			requestdispatch.forward(request, response);
		} else if (!Pattern.matches(
				"^[A-Za-z]+[.A-Za-z0-9]+@+[A-Za-z0-9]+(.[a-zA-Z]{2,4})+$",
				email)
				|| email == "") {

			String messageToDisplay = "!! Invalid Email !!";
			request.setAttribute("message", messageToDisplay);
			requestdispatch.forward(request, response);
		} else if (!confirmpassword.equals(password)) {
 System.out.println(confirmpassword +"    "+password);
			
			String messageToDisplay = "!! Confirm Password And Password Doesnot Match !!";
			request.setAttribute("message", messageToDisplay);
			requestdispatch.forward(request, response);
		} else if (!Pattern.matches("(^[0-9]+$)", contact) || contact == "") {

			String messageToDisplay = "!! Invalid Contact !!";
			request.setAttribute("message", messageToDisplay);
			requestdispatch.forward(request, response);
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
}
