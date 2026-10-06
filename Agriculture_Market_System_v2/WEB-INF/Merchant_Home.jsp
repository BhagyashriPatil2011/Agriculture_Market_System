<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>

   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  
  </head>
  

  <%

	if (request.getParameter("card_number") != null) {
		out.println("<script>alert('Payment Successfull and your order has been placed successfully')</script>");
	}
%>
  
    <style>
    
    body {margin:0;}
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
  
}

.active {
  background-color: #4CAF50;
}

li {
  float: Right;
}

li a, .dropbtn {
  display: inline-block;
  color: white;
  text-align: center;
  padding: 12px 16px;
  text-decoration: none;
}

li a:hover, .dropdown:hover .dropbtn {
  background-color: #1DCB7B;
  text-decoration: none;
  
}

#customers {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 90%;
  margin-left: 5%;
  margin-right: 5%;
  
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 10px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
 
}

.center {
display: flex;
justify-content: center;
}


</style>
  <body>
<ul>
<li><a href="/" >Logout</a></li>
<li><a href="/Merchant_Profile" >My Profile</a></li>
  <li class="active"><a href="/Merchant_Home" >Home</a></li>
    
  
</ul>
	</br>
		<div class="col-12">
			</br></br></br></br></br></br>
     <h3 class="text-center">Merchant Section</h3>
			<hr>
		</br>
			  <div class="form-row center">

    	 <div class="form-group col-md-2">
      
       <button class="form-control btn btn-primary" id="myInput" onclick="document.location='/MerchantCrops'">View Crop List</button>
    </div>
    &nbsp; &nbsp; &nbsp; &nbsp;
     <div class="form-group col-md-2">
      
       <button class="form-control btn btn-success" id="myInput" onclick="document.location='/AddCrop'">Add New Crop</button>
    </div>
    	  
  </div>
       
			<hr>
		</div>
		  


		</body>
  </html>
