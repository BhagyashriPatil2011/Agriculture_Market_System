<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Farmer Profile</title>

  <head>

   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  
  </head>
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



</style>
</head>
<body>
<ul>
<li><a href="/" >Logout</a></li>
<li class="active"><a href="/ViewProfile" >My Profile</a></li>
  <li><a href="/Farmer_Home" >Home</a></li>
    
  
</ul>
	</br></br></br>

<div class="main">
<h3 class="text-center">Farmer Profile</h3>
			<hr>
        <section class="signup">
            <!-- <img src="images/signup-bg.jpg" alt=""> -->
            <div class="container">
                <div class="signup-content">
                    <form method="post" action="" id="signup-form" class="signup-form" >
                      <%
		
			int id = 2;
            String sid;
            
         //   Class.forName("com.mysql.cj.jdbc.Driver"); 
    	//	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Online_Donation_System","root","");
          //  sid = request.getParameter("id");
          //  id = Integer.parseInt(sid);
		//	PreparedStatement ps=con.prepareStatement("SELECT * FROM user where id='"+id+"'");
		//	ResultSet rs=ps.executeQuery();
		//	while(rs.next())
			{
			%>
			<input type="hidden" name="id" value="">
                        <div class="form-group row">
		<label class="col-sm-2 col-form-label">Farmer Name</label>
	   <div class="col-sm-5">	<input type="text" class="form-control" disabled name="first_name" value="${user.full_name}">
		</div>
		</div>
		
		<div class="form-group row">
		<label class="col-sm-2 col-form-label">Address</label>
	   <div class="col-sm-5">	<input type="text" class="form-control" disabled name="last_name" value='${user.address}'>
		</div>
		</div>
		
		
		<div class="form-group row">
		<label class="col-sm-2 col-form-label">Mobile Number</label>
	   <div class="col-sm-5">	<input type="text" class="form-control" disabled name="mobile_number" value="${user.mobile_number}">
		</div>
		</div>
		
		
		<%
					//  session.setAttribute("username", rs.getString("username"));
			}
		%>

				
				<a href="/Farmer_Home" class="btn btn-primary customers" text-align="center">Back</a>
				<p></br></p>
                    </form>
                   
                </div>
            </div>
        </section>

    </div>

    <!-- JS -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="js/main.js"></script>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>

