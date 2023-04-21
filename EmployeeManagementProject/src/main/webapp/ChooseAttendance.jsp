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
<% 

        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
        response.setHeader("Pragma", "no-cache");	  //HTTP 1.0    
        response.setHeader("Expires", "0");  	//	Proxies 	
				
			       if(session.getAttribute("user")==null){
					response.sendRedirect("AdminLogin.html");
					} %>
					<jsp:include page="AdminNav.html" />

<!-- Columns are always 50% wide, on mobile and desktop -->
<div class="container-fluid ">
  <div class="row  bg-opacity-10 shadow-lg bg-body-tertiary rounded  d-flex justify-content-center pb-5">
  <div class="col-sm-12 d-flex justify-content-center">
  <h2 class="shadow-lg bg-body-tertiary ">Choose Attendence Type</h2>
  </div>
    <div class="col-md-6 col-sm-12 d-flex justify-content-center ">
    <div class="d-flex align-items-center">
    
  <div class="flex-shrink-0">
  <h3 class="shadow-lg bg-body-tertiary fst-italic fw-semibold ">Today's Attendence</h3>
    <img src="https://images.pexels.com/photos/8423020/pexels-photo-8423020.jpeg?auto=compress&cs=tinysrgb&w=600" alt="..." class="img-fluid img-thumbnail" width="300rem">
  </div>
  <div class="flex-grow-1 ms-3">
    <a href="TodayAttendence.jsp"  class="btn btn-outline-success btn-lg">Click</a>
  </div>
</div>
    </div>
    <div class="col-md-6 col-sm-12 d-flex justify-content-center ">
    <div class="d-flex align-items-center">
  <div class="flex-shrink-0">
  <h3 class="shadow-lg bg-body-tertiary fst-italic fw-semibold mt-2" >Update Attendence</h3>
    <img src="https://images.pexels.com/photos/5697254/pexels-photo-5697254.jpeg?auto=compress&cs=tinysrgb&w=600" alt="..." class="img-fluid img-thumbnail" width="300rem">
  </div>
  <div class="flex-grow-1 ms-3 ">
    <a href="ShowEmployeeForSeeAndUpdateAttendance.jsp" class="btn btn-outline-warning btn-lg">Click</a>
  </div>
</div></div>
  </div>
</div>
</body>
</html>