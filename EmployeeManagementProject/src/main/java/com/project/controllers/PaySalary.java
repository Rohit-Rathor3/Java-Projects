package com.project.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.dao.SalaryManagementDAO;

@WebServlet("/salary")
public class PaySalary extends HttpServlet{
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String idno = req.getParameter("idno");
		Float salary = Float.parseFloat(req.getParameter("paySalary"));
		try {
			int result = SalaryManagementDAO.updateSalary(idno, salary);
			if(result>0)
			{
				System.out.println("PaySalary.doPost() + Salary Deposited Successfully!!!");
				res.sendRedirect("/EmployeeManagementProject/AdminPanel.jsp");
			}
			else
			{
				System.out.println("PaySalary.doPost()  + Salary deposition fail!!!!");
			}
		}
		catch(Exception e)
		{
			System.out.println("PaySalary.doGet() "+e.getMessage());
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}

}
