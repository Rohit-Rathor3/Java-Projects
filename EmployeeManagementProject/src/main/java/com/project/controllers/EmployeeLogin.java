package com.project.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.dao.EmployeeDao;

@WebServlet("/employee")
public class EmployeeLogin extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String empDetails = req.getParameter("empDetails");
		int result = EmployeeDao.validateEmployee(empDetails);
		HttpSession session = req.getSession(true);
		session.setAttribute("empDetails", empDetails);
				
		if(result>0)
		{
			System.out.println("EmployeeLogin.doPost()" + "Employee Validation Successfull!!");
			RequestDispatcher rd = req.getRequestDispatcher("/EmployeePanel.jsp");
			rd.include(req,res);
		}
		else
		{
			System.out.println("EmployeeLogin.doPost()"+"Fail to validate Employee");
		}
		
	}
}
