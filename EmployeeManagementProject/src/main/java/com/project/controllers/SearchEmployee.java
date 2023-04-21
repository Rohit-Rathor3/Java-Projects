package com.project.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searchemp")
public class SearchEmployee extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			System.out.println(req.getParameter("searchEmp"));
			System.out.println("Ready to send redirection");
		RequestDispatcher rd = req.getRequestDispatcher("/SearchEmployee.jsp");
		rd.forward(req, res);
		System.out.println("SearchEmployee.doGet()"+ "request forwarded successfully !");
		}
		catch(Exception e)
		{
			System.out.println("SearchEmployee.doGet() "+e.getMessage());
		}
	}
	/*
	 * @Override public void doPost (HttpServletRequest req, HttpServletResponse
	 * res) throws ServletException, IOException {
	 * 
	 * RequestDispatcher rd = req.getRequestDispatcher("/search"); rd.forward(req,
	 * res); }
	 */

}
