<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css" integrity="sha384-b6lVK+yci+bfDmaY1u0zE8YYJt0TZxLEAFyYSLHId4xoVvsrQu3INevFKo+Xir8e" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD" crossorigin="anonymous"></script>
<title>All Employees</title>
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
         
    <%  List<EmployeeBean> empList = EmployeeDao.getAllEmployeeForDelete();
    %>
<div class="container text-center mt-3">
  <div class="row">
    <div class="col-12" >
      <h1 class="shadow-lg bg-body-tertiary ">Pay Salary Of Employees</h1> 
      <form class="d-flex mt-1 mb-1" role="search" action="searchemp">
        <input class="form-control me-2" type="search" placeholder="Search Employee By Name ..." aria-label="Search" name="searchEmp">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div><!-- col-12 -->
    
    <%for(EmployeeBean em : empList){ float salary = SalaryManagementDAO.generateFinalSalary(em.getIdno());%>
    <div class="col-sm-6 col-md-3 shadow-lg  mb-1 bg-body-tertiary rounded"  >
    <div class="card" >
  <div class="card-body">
    <h5 class="card-title bg-info-subtle shadow-lg bg-body-tertiary"><%=em.getName() %></h5>
  </div> <!-- card-body -->
  <ul class="list-group list-group-flush">
    <li class="list-group-item fw-bold">Father Name:- <%=em.getFname() %></li>
    <li class="list-group-item fw-bold">ID No:- <%=em.getIdno()%></li>
    <%if(salary<0){%>
    <li class="list-group-item fw-bold bg-danger opacity-90">Due:- <%=salary%></li>
    <%}else{ %>
    <li class="list-group-item fw-bold bg-info opacity-90">Due:- <%=salary%></li>
    <%} %>
    
    
  </ul>
                      <!--                          making payment generation pop message  -->
                      <button class="btn btn-outline-success" onclick="paySal(<%=em.getIdno() %>)" >Click To Pay</button>   
                                 
                     
</div> <!-- Card -->


    </div>  <!-- col-sm-6 -->
    <div id="<%=em.getIdno() %>" style="display:none" class=" shadow-lg  bg-gradient  rounded m-4 col-sm-12 col-md-6" > -->
<form action="http://localhost:3030/EmployeeManagementProject/salary" method="post" name="myform">
<h3 class="shadow-lg bg-info">Pay Salary</h3>
  <div class="mb-3 shadow-lg" >
    <input type="text" class="form-control " id="exampleInputEmail1" aria-describedby="emailHelp" value="<%=em.getName()%>" readonly>
  </div>
  <div class="mb-3 shadow-lg">
    <input type="text" class="form-control" id="exampleInputPassword1" name="idno" readonly value="<%=em.getIdno()%>">
  </div>
  <div class="mb-3 shadow-lg">
  <label>Due</label>
    <input type="number" class="form-control" id="exampleInputPassword1" name="idn"  value="<%=salary %>" readonly required>
  </div>
  <div class="mb-3 shadow-lg">
    <input type="number" class="form-control" id="exampleInputPassword1" name="paySalary" required>
  </div>
  <div class="d-grid gap-2">
  <button type="submit" class="btn btn-outline-success " onclick="myFunction()"><h3>Pay</h3></button>
</div>
  
</form>
</div>

    <%}%>
     
  </div>
</div>
  <script>
function paySal(divname)
{
	var x = document.getElementById(divname);
	if(x.style.display==="none")
		{
		x.style.display ="block";
		}
	else
		{
		x.style.display='none';
		}
	}
	
function myFunction() {
	  document.getElementById("myForm").reset();
	}
	
	
</script>
</body>
</html>