
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.example.AgricultureMarketSystem.DBConnection.*"%>
<%@page import="java.sql.Connection"%>
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
<li><a href="/Farmer_Profile" >My Profile</a></li>
  <li class="active"><a href="/Farmer_Home" >Home</a></li>
    
  
</ul>
	</br>
	
	<form action="/showMerchant" method="post">
		<div class="col-12">
			
     <h3 class="text-center">Farmer Section</h3>
			<hr>
			
			  <div class="form-row center">
	
    
     <div class="form-group col-md-2">
     
      <select id="state" class="form-control" name="crop">
         <option value="ALL" selected="selected">Select Crop</option>
        								   <option>Wheat</option>
                                           <option>Rice</option>
                                           <option>Jowar</option>
                                           <option>Cucumber</option>
                                           <option>Capsicum</option>
                                           <option>Spinach</option>
                                           <option>Turdal</option>
                                           <option>Mugdal</option>

      </select>
     
    </div>
   
     &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
     <div class="form-group col-md-1">
      
       <button class="form-control btn btn-primary" type="submit">View Details</button>
    </div>
    	  
  </div>
       	
			<hr>
		</div>
		</form>

		  <%  
		  
		  Object crop = request.getAttribute("crop");
		  
			System.out.println("Page Value"+crop);
		  
		  
		  if(crop != null )
		  {
		  
			    int id;
	            String sid;
				Connection con=DbConnection.getConnection();
				PreparedStatement ps=con.prepareStatement("SELECT * FROM crop c,user u WHERE crop_name='"+crop+"' and c.merchant_id = u.id order by price desc");
				ResultSet rs=ps.executeQuery();
		
		  %>
		  
		  <h3 class="text-center"><%=crop %> Details</h3>
			<table class="table" id ="customers">
				<thead class="thead-dark">
					<tr>
						<th scope="col">SR. NO.</th>
						<th scope="col">MERCHANT NAME</th>
						<th scope="col">PRICE (Per 100 KG)</th>
						<th scope="col">QUANTITY</th>
						<th scope="col" class = "text-center">ACTION</th>
					</tr>
				</thead>
				<tbody id="myTable">
			<%
			  int i=1;
			while(rs.next())
			{
	
		
	  
			%>
					<tr>
					
						<td><%=i++ %></td>
						<td><%=rs.getString("full_name") %>						</td>
						
						<td><%=rs.getString("price") %>		</td>
						<td><%=rs.getString("quantity") %>		 </td>
						<td class = "text-center"><a href="/Show_Merchant_Profile/<%=rs.getInt("u.id") %>"
							class="btn btn-success mt-4">View Profile</a></td>
					</tr>
			

					<%
				}
		  					}

						%>
						
								
				</tbody>
			</table>

		</body>
  </html>
