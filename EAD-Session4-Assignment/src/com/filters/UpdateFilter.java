package com.filters;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class UpdateFilter implements javax.servlet.Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		RequestDispatcher requestdispatch = request
				.getRequestDispatcher("edit.jsp");

		String email = request.getParameter("email");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String contact = request.getParameter("contact");
		String company = request.getParameter("company");

		if (firstname == null && lastname == null && email == null
				&& contact == null) {

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
				"^[A-Za-z]+[.A-Za-z0-9]+@+[A-Za-z0-9]+(.[a-zA-Z]{2,4})+$",
				email)
				|| email == "") {

			String messageToDisplay = "!! Invalid Email !!";
			request.setAttribute("message", messageToDisplay);
			requestdispatch.forward(request, response);

		} else if (!Pattern.matches("(^[0-9]+$)", contact) || contact == "") {

			String messageToDisplay = "!! Invalid Contact !!";
			request.setAttribute("message", messageToDisplay);
			requestdispatch.forward(request, response);

		} else if ("select".equals(company)) {

			String messageToDisplay = "!! Organization cannot be blank !!";
			request.setAttribute("message", messageToDisplay);
			requestdispatch.forward(request, response);

		} else {

			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
