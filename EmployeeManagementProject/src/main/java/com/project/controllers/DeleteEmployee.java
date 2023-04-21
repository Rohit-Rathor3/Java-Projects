package com.project.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.dao.EmployeeDao;
import com.project.dao.SalaryManagementDAO;
@WebServlet("/delete")
public class DeleteEmployee extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");
		int result = EmployeeDao.deleteEmployee(id);
		SalaryManagementDAO.deleteEmpFromSalaryMgmt(id);
		if(result>0)
		{
			System.out.println("DeleteEmployee.doGet() "+"Employee deleted successfully!!");
			res.sendRedirect("/EmployeeManagementProject/AdminPanel.jsp");
			 
		}
		else
		{
			System.out.println("DeleteEmployee.doGet() "+" Fail to  deleted Employee !");
			// error page
		}
		
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);

}
}
