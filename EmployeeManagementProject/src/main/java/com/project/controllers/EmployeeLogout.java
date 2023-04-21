package com.project.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/emplogout")
public class EmployeeLogout extends HttpServlet{
@Override
   public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	try
	{
		HttpSession session=req.getSession();
	    session.removeAttribute("empDetails");
	   	session.invalidate();
	   	res.sendRedirect("/EmployeeManagementProject/emplogin.html");
	}
	catch(Exception e)
	{
		System.out.println("EmployeeLogout.doGet()"+e.getMessage());
	}
}
}
