<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css" integrity="sha384-b6lVK+yci+bfDmaY1u0zE8YYJt0TZxLEAFyYSLHId4xoVvsrQu3INevFKo+Xir8e" crossorigin="anonymous">
<title>All Announcements</title>
</head>
<body>
<%@page import="com.project.beans.*, com.project.dao.* ,java.util.*" %>
<% response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
         response.setHeader("Pragma", "no-cache");	  //HTTP 1.0    
         response.setHeader("Expires", "0");  	//	Proxies  %>
         
			      <%  if(session.getAttribute("user")==null){
					response.sendRedirect("AdminLogin.html");
					} %>
					<jsp:include page="AdminNav.html" />
         
    <%  List<AnnouncementBean> annList = AnnouncementDAO.getAnnouncementDetails();
    %>
    
    <div class="container">
    <div class="row mt-5">
   
    <%for(AnnouncementBean ann :annList) {%>
    <div class="col-sm-12 col-md-6 shadow-lg p-3 mb-5 bg-body-tertiary rounded">
    <div class="card text-center">
  <div class="card-header bg-dark">
    <p class="text-uppercase fw-bolder text-light "> <%=ann.getTitle() %><p>
  </div>
  <div class="card-body">
    
    <p class="card-text"><%=ann.getMessage() %></p>
    <a href="http://localhost:3030/EmployeeManagementProject/announcement?title=<%=ann.getTitle() %>" class="btn btn-outline-danger">Delete</a>
  </div>
  <div class="card-footer text-muted">
   <p class="fst-italic fw-semibold">Posted on:- <%=ann.getDate() %></p>
  </div>
</div>
    </div>
    <%}%>
    
   <!--  <div class="col-sm-12 d-flex justify-content-center shadow-lg  bg-body-tertiary rounded">
    <h2>No Record Found!!</h2>
    </div> --> 
   
    </div>
    </div>
</body>
</html>