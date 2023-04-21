package com.project.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.beans.EmployeeBean;
import com.project.dao.EmployeeDao;


public class EmployeeRegistration extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter object
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		  
		try 
		{
		
		    EmployeeBean emp = new EmployeeBean();
		    emp.setName(req.getParameter("name"));
			emp.setFname(req.getParameter("fname"));
			emp.setIdno(req.getParameter("idno"));
			emp.setEmail(req.getParameter("email"));
			emp.setPhoneno(req.getParameter("phoneno"));
			emp.setAddress(req.getParameter("address"));
			emp.setSalary(req.getParameter("salary"));
			emp.setDoj(req.getParameter("doj"));
			emp.setDesignation(req.getParameter("designation"));
			emp.setFactory(req.getParameter("factory"));
			
			EmployeeDao.registerEmployee(emp);
			RequestDispatcher rd = req.getRequestDispatcher("AdminPanel.jsp");
			rd.forward(req, res);
		}
		catch(Exception e)
		{
			//error page
		}
	}//doGet
	
	
}//class
