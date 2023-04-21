<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css" integrity="sha384-b6lVK+yci+bfDmaY1u0zE8YYJt0TZxLEAFyYSLHId4xoVvsrQu3INevFKo+Xir8e" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Employee Panel</title>
</head>
<body>
<% response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
         response.setHeader("Pragma", "no-cache");	  //HTTP 1.0    
         response.setHeader("Expires", "0");  	//	Proxies  %>
         <%@page import="com.project.beans.*, com.project.dao.* ,java.util.*" %>
         
         <% if(session.getAttribute("empDetails")==null){
					response.sendRedirect("emplogin.html");
					} %>
					<jsp:include page="EmpNav.jsp" />
				<%EmployeeBean emp = EmployeeDao.showEmpAfterLogin(request.getParameter("empDetails")); %>	
				
				<!-- Showing Salary / Due Related Data -->
                                    <%float due = SalaryManagementDAO.generateFinalSalary(emp.getIdno()); %>
					
					<!-- Showing Personal Details -->
					<div class="container mt-3">
					<div class="row">
					<div class="col-sm-12 col-md-8 d-flex justify-content-center shadow-lg  mb-2 bg-body-tertiary rounded">
					<h2>Personal Details</h2>
					</div>
					<div class="col-sm-12 col-md-8 d-flex justify-content-center shadow-lg p-3 mb-5 bg-body-tertiary rounded">
					<div class="card border-primary mb-3" style="max-width: 18rem;">
  <div class="card border-warning " style="max-width: 18rem;">
  <div class="card-header bg-dark text-uppercase text-light fw-semibold "><%=emp.getName()%></div>
  <div class="card-body">
    <h5 class="card-title">S/O :- <%=emp.getFname() %></h5>
    <h5 class="card-title">ID No :- <%=emp.getIdno() %></h5>
    <h5 class="card-title">Email :- <%=emp.getEmail() %></h5>
    <h5 class="card-title">Phone No :- <%=emp.getPhoneno() %></h5>
    <h5 class="card-title">DOJ :- <%=emp.getDoj() %></h5>
    <h5 class="card-title">Address :- <%=emp.getAddress() %></h5>
    <h5 class="card-title">Salary :- <%=emp.getSalary() %></h5>
    <h5 class="card-title">Designation :- <%=emp.getDesignation() %></h5>
    <h5 class="card-title">Factory :- <%=emp.getFactory() %></h5>
    <div class="d-grid gap-2 d-md-block">
  <button class="btn btn-outline-success" type="button">Your Due :- <%=due %></button>
</div>
    
  </div>
</div>
</div>
                                    
                                
</div>
</div>

</body>
</html>