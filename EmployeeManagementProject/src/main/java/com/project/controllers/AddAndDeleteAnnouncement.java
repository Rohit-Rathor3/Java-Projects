package com.project.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.beans.AnnouncementBean;
import com.project.dao.AnnouncementDAO;
import com.project.dao.AttendanceDAO;

@WebServlet("/announcement")
public class AddAndDeleteAnnouncement extends HttpServlet{

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String message = req.getParameter("message");
		String title = req.getParameter("title");

	   try {
			String date = AttendanceDAO.getInsertingDate();
			AnnouncementBean ann = new AnnouncementBean();
			ann.setTitle(title);
			ann.setMessage(message);
			ann.setDate(date);
			int result = AnnouncementDAO.insertAnnoucement(ann);
			if(result>0) {
			System.out.println("AddAndDeleteAnnouncement.doPost() " + "Annoucement inserted successfully!");
			res.sendRedirect("/EmployeeManagementProject/AdminPanel.jsp");
			}
		else
			System.out.println("AddAndDeleteAnnouncement.doPost() " + "Fail to insert Annoucement !!");
		}
		catch(Exception e)
		{
			System.out.println("AddAndDeleteAnnouncement.doPost() "+e.getMessage() );
		}
	   
		}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String title = req.getParameter("title");
		 try {
				int result = AnnouncementDAO.deleteAnnoucement(title);
				if(result>0) {
					System.out.println("AddAndDeleteAnnouncement.doGet() "+ "Announcement deleted successfully!!");
					res.sendRedirect("/EmployeeManagementProject/AdminPanel.jsp");
				}
				else
					System.out.println("AddAndDeleteAnnouncement.doGet() "+ "Fail to delete Announcement!!");
			}
			catch(Exception e)
			{
				System.out.println("AddAndDeleteAnnouncement.doGet()"+e.getMessage());
			}
	}
	
}
