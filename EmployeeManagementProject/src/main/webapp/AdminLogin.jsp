<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css" integrity="sha384-b6lVK+yci+bfDmaY1u0zE8YYJt0TZxLEAFyYSLHId4xoVvsrQu3INevFKo+Xir8e" crossorigin="anonymous">

<title>Admin Login</title>
</head>
<body>
<div class="container d-flex justify-content-center ">
<div class="row w-100">
<div class="col-sm-12 col-md-8 d-flex justify-content-center shadow-lg p-3 mb-5 bg-body-tertiary rounded mt-5">
<form action="http://localhost:3030/EmployeeManagementProject/admin" method="post" class="shadow-lg p-3 mb-5 bg-body-tertiary rounded">
<span class="ps-5"> <a href="index.jsp" ><img src="https://www.pngkit.com/png/detail/41-413073_5422c3418a632d4241caa626-home-icon-home-icons-for-website-png.png" width="100rem" height="100rem"></a></span>
<div class="mb-3 bg-dark ">
   <h2 class="text-light">Admin Login</h2>

  </div>
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label"><i class="bi bi-person"></i></span>Username</label>
    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="uname" autocomplete="off" required>

  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label"><i class="bi bi-lock-fill"></i>Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1" name="password" autocomplete="off" required>
  </div>
  
  <div class="d-grid gap-2">
 
    <button type="submit" class="btn btn-outline-success">Login</button>
 
</div>
  
  
</form>
</div>
</div>
</div>
</body>
</html>