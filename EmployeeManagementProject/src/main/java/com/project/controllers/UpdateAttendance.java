package com.project.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.dao.AttendanceDAO;

/*@WebServlet("/updateAttendance")*/
public class UpdateAttendance extends HttpServlet{

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			String id = req.getParameter("idno");
			Float attend = Float.parseFloat(req.getParameter("newAttendance"));
			String date = AttendanceDAO.getInsertingDate();
			
			int result = AttendanceDAO.updateAttendance(id, attend, date);
			if(result>0)
			{
				System.out.println("UpdateAttendance.doPost() "+ "Attendance updated successfully");
				res.sendRedirect("/EmployeeManagementProject/AdminPanel.jsp");
			}
			else
			{
				System.out.println("UpdateAttendance.doPost() "+ "Fail to update attendance");
			}
		}
		catch(Exception e)
		{
			System.out.println("UpdateAttendance.doPost() "+e.getMessage());
		}
	}
	
	/*
	 * @Override public void doGet(HttpServletRequest req, HttpServletResponse res)
	 * throws ServletException, IOException { doPost(req,res); }
	 */
}
