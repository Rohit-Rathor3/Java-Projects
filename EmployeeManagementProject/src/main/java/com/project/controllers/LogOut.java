package com.project.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/logout")
public class LogOut extends HttpServlet {
@Override
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	HttpSession session=req.getSession();
    session.removeAttribute("user");
   	session.invalidate();
   	req.setAttribute("logMessage", "ok");
   	
   	RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
	    rd.include(req, res);
	
}
}
