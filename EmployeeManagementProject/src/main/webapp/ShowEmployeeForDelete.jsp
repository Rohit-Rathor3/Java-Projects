<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css" integrity="sha384-b6lVK+yci+bfDmaY1u0zE8YYJt0TZxLEAFyYSLHId4xoVvsrQu3INevFKo+Xir8e" crossorigin="anonymous">
<title>All Employees</title>
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
         
    <%  List<EmployeeBean> empList = EmployeeDao.getAllEmployeeForDelete(); %>
<div class="container text-center mt-3">
  <div class="row">
    <div class="col-12">
      <h1 class="shadow-lg bg-body-tertiary ">All Registered Employees</h1> 
    </div>
    <%for(EmployeeBean em : empList){ %>
    <div class="col-sm-6 col-md-3 shadow-lg  mb-1 bg-body-tertiary rounded">
    <div class="card" >
  <div class="card-body">
    <h5 class="card-title bg-info-subtle shadow-lg bg-body-tertiary"><%=em.getName() %></h5>
  </div>
  <ul class="list-group list-group-flush">
    <li class="list-group-item fw-bold">Father Name:- <%=em.getFname() %></li>
    <li class="list-group-item fw-bold">ID No:- <%=em.getIdno()%></li>
  </ul>
  <div class="card-body">
    <a href="http://localhost:3030/EmployeeManagementProject/delete?id=<%=em.getIdno()%>" class="btn btn-outline-danger">Delete</a>
 
  </div>
</div>
    </div>
    <%} %>
    
  </div>
</div>
</body>
</html>