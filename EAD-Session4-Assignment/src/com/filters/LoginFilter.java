package com.filters;

import java.util.regex.Pattern;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//Filter class to validate fields in Login page 
public class LoginFilter implements javax.servlet.Filter {
	public void doFilter(final ServletRequest request,
			final ServletResponse response, FilterChain chain)
			throws java.io.IOException, javax.servlet.ServletException {

		RequestDispatcher requestdispatch = request
				.getRequestDispatcher("login.jsp");

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if (email == null && password == null) {

			String message = "!! Fields Cannot be blank !!";
			request.setAttribute("message", message);
			requestdispatch.forward(request, response);

		} else if (!Pattern.matches(
				"^[A-Za-z]+[.A-Za-z0-9]+@+[A-Za-z0-9]+(.[a-zA-Z]{2,4})+$",
				email)
				|| email.length() < 3) {

			String message = "!! Invalid Email !!";
			request.setAttribute("message", message);
			requestdispatch.forward(request, response);
		} else if (!Pattern.matches(
				"^(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])(?=.*[a-z]).{8,}$",
				password)) {

			String message = "!! Invalid Password !!";
			request.setAttribute("message", message);
			requestdispatch.forward(request, response);
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}
