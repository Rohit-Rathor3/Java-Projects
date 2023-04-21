 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Panel</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css" integrity="sha384-b6lVK+yci+bfDmaY1u0zE8YYJt0TZxLEAFyYSLHId4xoVvsrQu3INevFKo+Xir8e" crossorigin="anonymous">

<link rel="stylesheet" href="style.css">
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
<div class="container-fluid text-center shadow mt-2 mb-2 bg-body-tertiary rounded ">
  <div class="row">
    <div class="col-sm-12 shadow p-3 mb-5 bg-body-tertiary rounded mt-2">
        <div class="d-grid gap-2 ">
            <a href="ChooseAttendance.jsp" class="btn  btn-outline-info" type="button">
                <h2 class="">Make Attendence</h2>
            </a>
          </div>
    </div>
    <div class="row ">
        <div class="col-sm-12 " >
            <h2 class="shadow-sm bg-body-tertiary rounded fw-semibold  ">Emplyee Section</h2>
        </div>
    <div class="col-md-3 col-sm-12 d-flex justify-content-center p-1 shadow-lg bg-body-tertiary rounded">
        <div class="card shadow-lg bg-body-tertiary rounded" style="width: 10rem;">
            <img src="https://images.pexels.com/photos/4050319/pexels-photo-4050319.jpeg?auto=compress&cs=tinysrgb&w=600" class="card-img-top" alt="...">
              <a href="empreg.jsp" class="btn btn-outline-secondary">Register </a>
            </div>
          </div>
    <div class="col-md-3 col-sm-12 d-flex justify-content-center p-1 shadow-lg bg-body-tertiary rounded ">
        <div class="card shadow-lg bg-body-tertiary rounded" style="width: 10rem;">
            <img src="https://images.pexels.com/photos/927022/pexels-photo-927022.jpeg?auto=compress&cs=tinysrgb&w=600" class="card-img-top" alt="...">
              <a href="ShowEmployeeForUpdate.jsp" class="btn btn-outline-secondary">Update</a>
            </div>
          </div>
    <div class="col-md-3 col-sm-12 d-flex justify-content-center p-1 shadow-lg bg-body-tertiary rounded">
        <div class="card shadow-lg bg-body-tertiary rounded" style="width: 10rem;">
            <img src="https://images.pexels.com/photos/5673488/pexels-photo-5673488.jpeg?auto=compress&cs=tinysrgb&w=600" class="card-img-top" alt="...">
              <a href="ShowEmployeeForDelete.jsp" class="btn btn-outline-secondary">Delete</a>
            </div>
          </div>


          <div class="col-md-3 col-sm-12 d-flex justify-content-center p-1 shadow-lg bg-body-tertiary rounded" >
            <div class="card shadow-lg bg-body-tertiary rounded" style="width: 10rem;">
                <img src="https://images.pexels.com/photos/5424636/pexels-photo-5424636.jpeg?auto=compress&cs=tinysrgb&w=600" class="card-img-top" alt="...">
                  <a href="MultiPurpose.jsp" class="btn btn-outline-secondary">Search</a>
                </div>
              </div>  
            </div>     

            <div class="col-sm-12 shadow p-3 mb-5 bg-body-tertiary rounded">
                <div class="d-grid gap-2 ">
                    <a href="ShowEmployeesForSalary.jsp" class="btn  btn-outline-success" type="button">
                        <h2 class="">Pay Salary</h2>
                    </a>
                  </div>
            </div>
            <div class="col-sm-12 shadow p-3 mb-2 bg-body-tertiary rounded">
                <div class="d-grid gap-2 ">
                    <button class="btn  btn-outline-dark" type="button" onclick="announcementSec()">
                        <h2 class="">Announcement</h2>
                    </button>
                  </div>
            </div>
            <div class="row shadow-lg p-3  bg-body-tertiary rounded ms-2" id="mydiv" style="display:none">    
            <div class=" col-md-6 shadow p-2 m-2 bg-body-tertiary rounded">
            <div class="d-grid gap-2 ">
  <a class="btn btn-outline-secondary" type="button" href="http://localhost:3030/EmployeeManagementProject/Announcement.jsp"><p class="fw-bold fst-italic text-black">New Announcement</p></a>

</div>
            </div>
            <div class=" col-md-6 shadow p-2 m-2 bg-body-tertiary rounded">
<div class="d-grid gap-2">
  <a class="btn btn-outline-secondary " href="ShowAllAnouncementsForDelete.jsp" type="button"><p class="fw-bold fst-italic text-black">Delete Announcement</p></a>

</div>
            
            </div>
            </div>
   </div>

</body>
<script>
function announcementSec()
{
	var x = document.getElementById("mydiv")
	if(x.style.display==="none")
		{
		x.style.display="block"
		}
	else
		{
		x.style.display="none"
		}
	}
</script>
</html>