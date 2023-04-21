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
         
         <% if(session.getAttribute("user")==null){
					response.sendRedirect("AdminLogin.html");
					} %>
					<jsp:include page="AdminNav.html" />
<%String name = request.getParameter("searchEmp"); 
List<EmployeeBean> e = EmployeeDao.getEmpFoSearch(name);
%>   

<div class="container ">
    <div class="row d-flex justify-content-center m-5">
    <%for(EmployeeBean emp:e) {%>
<div class="col-sm-12 col-sm-8 d-flex justify-content-center mb-3 shadow-lg p-3 mb-5 bg-body-tertiary rounded">
  <div class="card border-success mb-3 shadow-lg p-3 mb-5 bg-body-tertiary rounded" style="max-width: 18rem;">
  <div class="card-header bg-transparent border-success shadow bg-body-tertiary rounded  fw-bold fst-italic text-uppercase"><%=emp.getName() %></div>
  <div class="card-body text-success">
    <h5 class="card-title">S/O         : <%=emp.getFname() %></h5>
    <h5 class="card-title">Id No       : <%=emp.getIdno() %></h5>
    <h5 class="card-title">Contact     :<%=emp.getPhoneno() %></h5>
    <h5 class="card-title">Email       : <%=emp.getEmail()%></h5>
    <h5 class="card-title">DOJ         : <%=emp.getDoj() %></h5>
    <h5 class="card-title">Designation : <%=emp.getDesignation() %></h5>
    <h5 class="card-title">Salary      : <%=emp.getSalary() %></h5>
    <h5 class="card-title">Address     : <%=emp.getAddress() %></h5>
   </div>
    </div>
    <%} %>
    </div>
    </div>
</body>
</html>