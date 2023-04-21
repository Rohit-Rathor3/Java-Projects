<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css" integrity="sha384-b6lVK+yci+bfDmaY1u0zE8YYJt0TZxLEAFyYSLHId4xoVvsrQu3INevFKo+Xir8e" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="com.project.beans.*, com.project.dao.* ,java.util.*" %>
<% 

        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
        response.setHeader("Pragma", "no-cache");	  //HTTP 1.0    
        response.setHeader("Expires", "0");  	//	Proxies 	
				
			       if(session.getAttribute("user")==null){
					response.sendRedirect("AdminLogin.html");
					} %>
					<jsp:include page="AdminNav.html" />
         
    <%  List<AttendenceBean> annList = AttendanceDAO.getAttendanceOfParticularDay(AttendanceDAO.getInsertingDate());
    %>
    <div class="container mt-2">
    <div class="row">
    <div class="col-sm-12 d-flex justify-content-center shadow-lg p-1 bg-body-tertiary rounded ">
    <h2>Update Attendance</h2>
    </div>
    <%for(AttendenceBean em : annList) { String attenType =null; float attend = em.getAttendence(); if(attend==1){ attenType="Present";}else{attenType ="Absent";} 
    %>
    <div class="col-sm-12 shadow bg-body-tertiary mt-2 col-md-12 ">
    <div class="card">
  <h5 class="card-header bg-body-secondary text-dark  bg-gradient"><%=em.getName() %></h5>
  <div class="card-body">
   <h4>S/O :- <%=em.getName() %></h4>
   <h4>ID No:- <%=em.getIdno() %></h4>
   <%if(em.getAttendence()==1) {%>
   <h4>Present</h4><%} else{%>
   <h4>Absent</h4><%} %>
   
   <h4></h4>
  </div>
  <button type="button" class="btn btn-outline-info" onclick="updateAttendance(<%=em.getIdno()%>)">Update</button>
</div>
</div>
<div class="col-sm-8 col-md-8 shadow-lg p-3 mb-5 bg-body-tertiary rounded m-3 bg-info-subtle" id="<%=em.getIdno()%>" style="display:none" >
<form class="row g-3" action="http://localhost:3030/EmployeeManagementProject/updateAttendance" method="POST">
  <div class="col-auto">
    <label for="staticEmail2" class="visually-hidden">Name -> </label>
    <input type="text" readonly class="form-control-plaintext"  value="<%=em.getName() %>" name="name">
  </div>
  <div class="col-auto">
    <label  class="visually-hidden">Idno -> </label>
    <input type="text" class="form-control"  name="idno" readonly value="<%=em.getIdno() %>">
  </div>
  <div class="col-auto">
    <label  class="visually-hidden"> Attendance -> </label>
    <input type="text" class="form-control"  name="attendance" readonly value="<%=attenType %>">
  </div>
 <%if(em.getAttendence()==1) {%>
 <div class="form-check form-switch">Make Absent
  <input class="form-check-input" type="checkbox" role="switch"  name="newAttendance" value="0" required> 
</div>
 <%} else{%>
 <div class="form-check form-switch">Make Present
  <input class="form-check-input" type="checkbox" role="switch"   name="newAttendance" value="1" required>
</div>
 <%} %>
  <div class="col-auto">
    <button type="submit" class="btn btn-outline-primary mb-3">Update Attendance</button>
  </div>
</form>
</div>
    <%} %>
    </div>
    </div>
    
    <script>
    function updateAttendance(id)
    {
    	var ele = document.getElementById(id);
    	if(ele.style.display==="none")
    		{
    		ele.style.display="block";
    		}
    	else
    		{
    		ele.style.display="none";
    		}
    }
    </script>
</body>


</html>