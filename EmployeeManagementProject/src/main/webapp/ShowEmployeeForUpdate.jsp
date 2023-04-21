<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css" integrity="sha384-b6lVK+yci+bfDmaY1u0zE8YYJt0TZxLEAFyYSLHId4xoVvsrQu3INevFKo+Xir8e" crossorigin="anonymous">
<link rel="stylesheet" href="validation.js">
<title>Update Employee</title>
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
         
    <%  List<EmployeeBean> empList = EmployeeDao.getEmpForUpdate();
    %>
    <div class="container mt-2">
    <div class="col-sm-12 d-flex justify-content-center">
    <h2 class="">Update Employee's Details</h2>
    </div>
    <div class="row d-flex justify-content-center ">
    <%for(EmployeeBean emp:empList) {%>
    <div class="col-sm-8 mt-3 ">
    <div class="card ">
  <div class="card-header">
    <%=emp.getName() %>
  </div>
  <div class="card-body">
    <h5 class="card-title">S/O :- <%=emp.getFname() %></h5>
    <p class="card-text">ID No:- <%=emp.getIdno() %></p>
    <button type="button" class="btn btn-outline-primary" onclick="updateEmp(<%=emp.getIdno()%>)">Update</button>
  </div>
</div>
    </div>
    
    
    <div class="col-sm-8 shadow-lg p-3 mb-5 bg-body-tertiary rounded" id="<%=emp.getIdno()%>" style="display:none">
    <form action="http://localhost:3030/EmployeeManagementProject/updateurl" name="regform" method="post" onsubmit="return validate()"  >
            <div class="input-group mb-3">
                <span class="input-group-text"><i class="bi bi-person"></i></span>
                <input type="text" class="form-control" name="name" placeholder="Name" required   id="name" value="<%=emp.getName()%>" readonly>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text"><i class="bi bi-person"></i></span>
                <input type="text" class="form-control" name="fname" placeholder="Father Name" required  value="<%=emp.getFname() %>" id="fname" readonly>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text"><i class="bi bi-telephone-plus"></i></span>
                <input type="text" class="form-control" name="phoneno"  required value="<%=emp.getPhoneno()%>" id="phoneno" pattern="[1-9]{1}[0-9]{9}" readonly>
               
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text"><i class="bi bi-envelope-fill"></i></span>
                <input type="email" class="form-control" name="email"  id="email" required value="" placeholder="<%=emp.getEmail()%>">
                
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text"><i class="bi bi-geo-alt"></i></span>
                <input type="text" class="form-control" name="address" id="address" placeholder="<%=emp.getAddress() %>" required  >
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text"><i class="bi bi-buildings"></i></span>
                <select name="designation" id="designation">
                    <option value="#">Choose Designation</option>
                    <option value="helper" selected>Helper</option>
                    <option value="operator">Operator</option>
                </select>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text"><i class="bi bi-calculator"></i></span>
                <input type="text" class="form-control" name="idno" id="idno" placeholder="ID details" required value="<%=emp.getIdno() %>" readonly>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text"><i class="bi bi-calculator"></i></span>
                <input type="number" class="form-control" name="salary" id="salary" placeholder="<%=emp.getSalary() %>" required  >
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text"><i class="bi bi-calendar2-date"></i></span>
                <input type="date" class="form-control" name="doj" required value="<%=emp.getDoj() %>" >
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text"><i class="bi bi-buildings"></i></span>
                <select name="factory" id="factory">
                    <option value="#">Choose factory</option>
                    <option value="rr polywire">RR Polywire</option>
                    <option value="krishna polywire">Krishna Polywire</option>
                    <option value="radhe polywire">Radhe Polywire</option>
                    <option value="Satyam industries">Stayam Industries</option>
                </select>
            </div>
            
            <div class=" d-grid ">
             <input type="submit" class="btn-outline-success btn"  ></input>
             <input type="reset" class=" btn-outline-danger btn mt-4"></input>
            </div>
        </form>
    </div>
    <%} %>
    </div>
    </div>
    
    <script>
    function updateEmp(myid)
    {
    	
    	var getEmp = document.getElementById(myid);
    	if(getEmp.style.display==="none")
    		{
    		getEmp.style.display = "block";
    		}
    	else
    		{
    		getEmp.style.display = "none";
    		}
    }
    
    </script>
</body>
</html>