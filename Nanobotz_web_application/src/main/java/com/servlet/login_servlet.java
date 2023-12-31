package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login_servlet")
public class login_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		try {
			List<login> userDetails = DBUtill.validate(userName, password);
			
			HttpSession session = request.getSession();
			int UID = userDetails.get(0).getId();
            session.setAttribute("UID", UID);
            
            RequestDispatcher dis = request.getRequestDispatcher("home.jsp");
    		dis.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
			dis.forward(request, response);
		}


	}
}
