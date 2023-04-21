package com.project.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.beans.EmployeeBean;
import com.project.dao.EmployeeDao;

@WebServlet("/updateurl")
public class UpdateEmployee extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			EmployeeBean emp = new EmployeeBean();
			emp.setEmail(req.getParameter("email"));
			emp.setAddress(req.getParameter("address"));
			emp.setSalary(req.getParameter("salary"));
			emp.setDesignation(req.getParameter("designation"));
			emp.setFactory(req.getParameter("factory"));
			emp.setIdno(req.getParameter("idno"));
			EmployeeDao.updateEmployee(emp);
			
			RequestDispatcher rd = req.getRequestDispatcher("AdminPanel.jsp");
			rd.forward(req, res);
		}
		catch(Exception e)
		{
			System.out.println("UpdateEmployee.doPost()"+e.getMessage());
		}
	}
}
