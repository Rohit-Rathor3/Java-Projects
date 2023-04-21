package com.project.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/admin")
public class AdminLogin extends HttpServlet{

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("password");
		if(uname.equals("root") && pwd.equals("root"))
		{
			HttpSession session = req.getSession(true);
			session.setAttribute("user", uname);
			RequestDispatcher rd = req.getRequestDispatcher("AdminPanel.jsp");
			rd.forward(req, res);
		}
	}
}
