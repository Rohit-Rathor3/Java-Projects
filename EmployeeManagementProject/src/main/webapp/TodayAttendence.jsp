<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css" integrity="sha384-b6lVK+yci+bfDmaY1u0zE8YYJt0TZxLEAFyYSLHId4xoVvsrQu3INevFKo+Xir8e" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<%@page import="com.project.beans.*, com.project.dao.* ,java.util.*" %>
<% response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
         response.setHeader("Pragma", "no-cache");	  //HTTP 1.0    
         response.setHeader("Expires", "0");  	//	Proxies  %>
         <% 	
			       if(session.getAttribute("user")==null){
					response.sendRedirect("AdminLogin.html");
					} %>
					<jsp:include page="AdminNav.html" />
         
    <%  List<EmployeeBean> empList = AttendanceDAO.getAllEmployeeForAttendance(); %>
    
    <!-- Creating dynamic form -->
    <div class="container mt-3">
    <div class="row shadow-lg shadow p-3 mb-5 bg-body-tertiary rounded bg-body-tertiary rounded">
    <div class="col-sm-12 d-flex justify-content-center">
    <h3 >Make Attendance</h3>
    </div>
    <form action="http://localhost:3030/EmployeeManagementProject/attendance" method="get">
    <%for(EmployeeBean em : empList){ %> 
    <div class="col-sm-12 shadow bg-body-tertiary mt-2 ">
    <div class="card">
  <h5 class="card-header bg-dark text-light bg-gradient"><%=em.getName() %></h5>
  <div class="card-body">
   <h4>S/O :- <%=em.getFname() %></h4>
   <h4>ID No:- <%=em.getIdno() %></h4>
  </div>
</div>
<div class="form-check form-switch">
  <input class="form-check-input" type="radio" role="switch" id="flexSwitchCheckDefault" name="<%=em.getIdno()%>" value="1" required>
  <label class="form-check-label" for="flexSwitchCheckDefault">Present</label>
</div>
<div class="form-check form-switch">
  <input class="form-check-input" type="radio" role="switch" id="flexSwitchCheckChecked" name="<%=em.getIdno()%>" value="0" required>
  <label class="form-check-label" for="flexSwitchCheckChecked" >Absent</label>
</div>
</div>
  <%} %>
  <div class="d-grid gap-2 p-2 mt-3">
  <button class="btn btn-outline-success" type="submit">Click</button>
</div>
</form>
</div>
    </div>

</body>
</html>

<!-- 

 -->