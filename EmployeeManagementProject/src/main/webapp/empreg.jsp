<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Registration Form</title><link href="style.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css" integrity="sha384-b6lVK+yci+bfDmaY1u0zE8YYJt0TZxLEAFyYSLHId4xoVvsrQu3INevFKo+Xir8e" crossorigin="anonymous">
<script language="JavaScript" src="validation.js"></script>
</head>
<% 

        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
        response.setHeader("Pragma", "no-cache");	  //HTTP 1.0    
        response.setHeader("Expires", "0");  	//	Proxies 	
				
			       if(session.getAttribute("user")==null){
					response.sendRedirect("AdminLogin.html");
					} %>
					<jsp:include page="AdminNav.html" />
<body class="bg-light">
 <div class="container-fluid" >
    <div class="row mt-2 shadow-lg p-3 mb-5 bg-body-tertiary rounded">
      <div class="col-lg-4 bg-white m-auto rounded-top shadow-lg p-3 mb-5 bg-body-tertiary rounded">
        <h3 style="color:black;" class="text-center pt-3 mb-3 shadow p-3  bg-body-tertiary rounded"  ><i>Employee Registration Form</i></h3>
        <!--form start-->
        <form action="empreg" name="regform" method="post" onsubmit="return validate()"  >
            <div class="input-group mb-3">
                <span class="input-group-text"><i class="bi bi-person"></i></span>
                <input type="text" class="form-control" name="name" placeholder="Name" required   id="name"autofocus>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text"><i class="bi bi-person"></i></span>
                <input type="text" class="form-control" name="fname" placeholder="Father Name" required  value="" id="fname" autofocus>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text"><i class="bi bi-telephone-plus"></i></span>
                <input type="text" class="form-control" name="phoneno"  required value=""autofocus id="phoneno" pattern="[1-9]{1}[0-9]{9}">
               
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text"><i class="bi bi-envelope-fill"></i></span>
                <input type="email" class="form-control" name="email" placeholder="email" id="email"autofocus required value="" >
                
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text"><i class="bi bi-geo-alt"></i></span>
                <input type="text" class="form-control" name="address" id="address"autofocus placeholder="address" required  >
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
                <input type="text" class="form-control" name="idno"autofocus id="idno" placeholder="ID details" required  >
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text"><i class="bi bi-calculator"></i></span>
                <input type="number" class="form-control" name="salary" id="salary"autofocus placeholder="Salary" required  >
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text"><i class="bi bi-calendar2-date"></i></span>
                <input type="date" class="form-control"autofocus name="doj" required  >
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text"><i class="bi bi-buildings"></i></span>
                <select name="factory" id="factory" required >
                    <option value="#">Choose factory</option>
                    <option value="rr polywire" selected>RR Polywire</option>
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
    </div>
 </div>
 
</body>
</html>