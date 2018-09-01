package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.enums.Status;
import com.facade.LoginFacade;

@SuppressWarnings("serial")
public class LoginController extends HttpServlet {
	/**
	 * Services method to process request from jsp page
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		LoginFacade loginfacade = LoginFacade.getInstance();

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		RequestDispatcher requestdispatch = request
				.getRequestDispatcher("profile.jsp");

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Status status = loginfacade.checkEmailAndPassword(email, password);
		
		if (status == Status.FOUND) {
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			
			String messageToShow = "!! Successfully Logged In !! ";
			request.setAttribute("message", messageToShow);
			requestdispatch.forward(request, response);
		} else {
			String messageToShow = "!! Login Id and Password Didnot Match !!";
			request.setAttribute("message", messageToShow);
			requestdispatch.forward(request, response);
		}

		out.close();
	}
}
