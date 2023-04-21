<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Announcement</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css" integrity="sha384-b6lVK+yci+bfDmaY1u0zE8YYJt0TZxLEAFyYSLHId4xoVvsrQu3INevFKo+Xir8e" crossorigin="anonymous">
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

  <div class="container-fluid">
    <div class="row-3 mt-lg-5">
        <div class="col-md-6 col-sm-12 p-3 md-3 bg-white m-auto rounded-top shadow-lg  bg-body-tertiary rounded">
            <div class="card mt-5">
                <div class="card-body">
                    <h2 class="text-center " style="color:black"> Announcement For Employees</h2>
                    <form action="http://localhost:3030/EmployeeManagementProject/announcement" method="post">
                        <div class="input-group mb-3 shadow  bg-body-tertiary rounded">
                            <input type="text" name="title" id="subject" class="form-control text-center" placeholder="Enter Title"autofocus required>

                        </div>
                        <div class="input-group-text mb-3 shadowbg-body-tertiary rounded">
                         <textarea  id="tital" cols="60" rows="5" placeholder="Enter message here ....." name="message"autofocus>
                         </textarea>
                        </div>
                        <div class=" d-grid ">
                            <input type="submit" class="btn-outline-success btn"  ></input>
                            <input type="reset" class=" btn-outline-danger btn mt-4"></input>
                           </div>
                    </form>
                </div>
            </div>
        </div>

    </div>
  </div>  

</body>
</html>