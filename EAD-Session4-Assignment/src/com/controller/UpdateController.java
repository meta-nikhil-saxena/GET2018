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

/**
 * Servlet implementation class Update
 */
@SuppressWarnings("serial")
public class UpdateController extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher requestDispatch = request.getRequestDispatcher("profile.jsp");
		UserFacade userfacade = UserFacade.getInstance();
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String email = request.getParameter("email");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		long contact = Long.parseLong(request.getParameter("contact"));
		String company = request.getParameter("company");
		String upload = request.getParameter("upload");
		String address = request.getParameter("address");

		User user = new User(firstname, lastname, upload, contact, "", email, address, company, "");
		
		Status status = userfacade.updateStatus(user);
		
		if(status.equals(Status.UPDATED)){			
			String messageToShow = "!! Updated !!";
			request.setAttribute("message", messageToShow);			
			requestDispatch.forward(request, response);
		}else{
			String messageToShow = "!! NOT UPDATED !!";
			request.setAttribute("message", messageToShow);			
			requestDispatch.forward(request, response);
		}		
		out.close();
	}

}
