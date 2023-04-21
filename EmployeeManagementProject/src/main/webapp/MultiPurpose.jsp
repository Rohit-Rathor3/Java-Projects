<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css" integrity="sha384-b6lVK+yci+bfDmaY1u0zE8YYJt0TZxLEAFyYSLHId4xoVvsrQu3INevFKo+Xir8e" crossorigin="anonymous">

<title>Multi Purpose</title>
</head>
<body>


<% 

        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
        response.setHeader("Pragma", "no-cache");	  //HTTP 1.0    
        response.setHeader("Expires", "0");  	//	Proxies 	
				
			       if(session.getAttribute("user")==null){
					response.sendRedirect("AdminLogin.html");
					} %>
					<jsp:include page="AdminNav.html" />
					
<div class="container text-center mt-2">
  <div class="row">
    <div class="col-12" >
      <h1 class="shadow-lg bg-body-tertiary ">All Registered Employees</h1> 
      <form class="d-flex mt-1 mb-1" role="search" action="searchemp">
        <input class="form-control me-2" type="text" placeholder="Search Employee By Name ...." aria-label="Search" name="searchEmp" required>
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div><!-- col-12 -->
    </div>
</body>
</html>