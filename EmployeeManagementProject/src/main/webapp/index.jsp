<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login Page</title>
    <link href="style.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css" integrity="sha384-b6lVK+yci+bfDmaY1u0zE8YYJt0TZxLEAFyYSLHId4xoVvsrQu3INevFKo+Xir8e" crossorigin="anonymous">
  </head>
  <body>
  
  <% 
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
        response.setHeader("Pragma", "no-cache");	  //HTTP 1.0    
        response.setHeader("Expires", "0");  	//	Proxies 
        %>
 <% String log = request.getParameter("logMessage"); 
 %>
 <% if(log!=null){ 
	 if(log.equals("ok")){%>
	 <jsp:include page="popMessages.jsp" />
	 <%}} %>

 
 
    <div class="container-fluid text-center cus_container ">
  <div class="row   border border-3 shadow-lg p-3 mb-5 bg-body-tertiary rounded-5 rounded-top-0 " >
  
  <!-- Adding Date -->
 <div class="col-md-12border border-warning-subtle shadow-lg bg-body-tertiary rounded-bottom  h1 bg-warning  bg-opacity-20">
  <div id = "clock" onload="currentTime()"></div>
  </div>
               <!-- Card 1 -->
    <div class="row pt-5">
    <div class="col-sm-12 d-flex justify-content-center col-md-5 ">
      <div class="card h-70 bg-success shadow-lg bg-body-tertiary rounded  shadow-sm border-5" style="width:18rem;" >
  <img src="https://st.depositphotos.com/2704315/3185/v/600/depositphotos_31854223-stock-illustration-vector-user-profile-avatar-man.jpg" card-img-top" alt="..." >
  <div class="card-body">
    <a href="AdminLogin.jsp" class="btn  btn-outline-success btn-lg">Admin Login</a>
  </div>
</div>
    </div>
    
    <div class="col-sm-12 d-flex justify-content-center  col-md-5">
                                          <!-- Card 2 -->
     <div class="card h-70 bg-danger shadow-lg bg-body-tertiary rounded border-5 " style="width:18rem;" >
  <img src="https://png.pngtree.com/png-vector/20190429/ourmid/pngtree-employee-icon-vector-illustration-in-flat-style-for-any-purpose-png-image_996955.jpg"  class=" card-img-top" alt="...">
  <div class="card-body">
    
    <a href="emplogin.html" class="btn  btn-outline-primary btn-lg">Employee Login</a>
  </div>
</div>
    </div>
    </div>
  </div>
  </div>
</div>
<script>
function currentTime() {
	  let date = new Date(); 
	  let hh = date.getHours();
	  let mm = date.getMinutes();
	  let ss = date.getSeconds();
	  let session = "AM";
	  
	  
 
	  var day=date.getDate();  
	  var month=date.getMonth()+1;  
	  var year=date.getFullYear();

	  if(hh === 0){
	      hh = 12;
	  }
	  if(hh > 12){
	      hh = hh - 12;
	      session = "PM";
	   }

	   hh = (hh < 10) ? "0" + hh : hh;
	   mm = (mm < 10) ? "0" + mm : mm;
	   ss = (ss < 10) ? "0" + ss : ss;
	    
	   let time = hh + ":" + mm + ":" + ss + " " + session;

	  document.getElementById("clock").innerText = day+"-"+month+"-"+year+" "+time; 
	  let t = setTimeout(function(){ currentTime() }, 1000);
	}

	currentTime();
</script>
  </body>
</html>