package com.project.controllers;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.beans.AttendenceBean;
import com.project.beans.EmployeeBean;
import com.project.dao.AttendanceDAO;
@WebServlet("/attendance")
public class Attendance extends HttpServlet {
	
	
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

			try {
			List<EmployeeBean> allEmp = AttendanceDAO.getAllEmployeeForAttendance();
			int totalId = allEmp.size();
			String storeIds[] = new String[totalId];
			int i=0;
			int resultTotal =0;
			
			for(EmployeeBean e :allEmp)
			{
				storeIds[i] = e.getIdno();
				Float attendence = Float.parseFloat(req.getParameter(storeIds[i]));
				AttendenceBean emp = new AttendenceBean();
				emp.setName(e.getName());
				emp.setAttendence(attendence);
				emp.setIdno(storeIds[i]);
				emp.setDate(AttendanceDAO.getInsertingDate());
				resultTotal += AttendanceDAO.insertAttendance(emp);
				i++;
			}
			if(resultTotal==i)
			{
				System.out.println("Attendance.doGet() "+"Attendence inserted successfully!!!!!!" );
				res.sendRedirect("/EmployeeManagementProject/AdminPanel.jsp");
			}
			else
			{
				System.out.println("Attendance.doGet() "+"Fail to insert attendance!!");
			}
			}
			catch(Exception e)
			{
				e.getMessage();
			}
			
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}
