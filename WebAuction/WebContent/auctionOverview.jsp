<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="controller.category.*"%>
<%@page import="model.category.*"%>
    <%@page import="controller.auction.*"%>
<%@page import="model.auction.*"%>
<%@page import="model.bid.*"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Khalid's Web Auction</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
     <link href="styles/signin.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header ">
      <a class="navbar-brand" href="index.jsp">Khalid's Web Auction</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="indexItemController">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Category <span class="caret"></span></a>
        <ul class="dropdown-menu">
         <% Category[] cat = (Category[]) request.getAttribute("category"); for (int i = 0; i < cat.length; i++) {  Category a = cat[i]; %>
			<li><a href="CategoryController?catid=<%out.print(a.getCatid());%>"><% out.print(a.getCatName()); %></a></li>
			<% } %>
        </ul>
      </li>
     
    </ul>
    <div class="col-sm-3 col-md-3 pull-right">
        <form class="navbar-form" role="search" action="SearchAuction" method="GET">
        <div class="input-group">
            <input type="text" class="form-control" placeholder="Search" name="name" >
            <div class="input-group-btn">
                <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
            </div>
        </div>
        </form>
        </div>
        <ul class="nav navbar-nav navbar-right">
        <% String userlayout = "";
            if(session.getAttribute("userid") == null) {
            	userlayout = "<li><a href='#'><span class='glyphicon glyphicon-user'></span> Sign Up</a></li><li><a href='login.jsp'><span class='glyphicon glyphicon-log-in'></span> Login</a></li>";
            }else{
            	userlayout = "<li class='dropdown'><a class='dropdown-toggle' data-toggle='dropdown' href='MyDetails'>My Profile <span class='caret'></span></a><ul class='dropdown-menu'><li><a href='MyDetails'>My Details</a></li><li><a href='CreateAuction'>Create an Auction</a></li><li><a href='MyAuction'>My Auctions</a></li><li><a href='LogOut'>Log Out</a></li></ul></li>";
            }
            %>
            
            <%out.print(userlayout); %>
    </ul>
    
  </div>
</nav>

<div class="container">
  <h2>Auction Overview</h2>
  <p class="text-danger">Note: Only logged in users are able to bid.</p>            
  <table class="table table-hover">
    <thead>
      <tr>
        <th>Item Id</th>
       <th>Auction Id</th>
       <th>Item Name</th>
       <th>Category</th>
       <th>Start Price</th>
       <th>Current Bid</th>
      </tr>
    </thead>
    <tbody>
       <%String id = ""; 
       	 String webBid = "";%>
       
       <% AuctionItem[] auc = (AuctionItem[]) request.getAttribute("auction"); for (int i = 0; i < auc.length; i++) {  AuctionItem a = auc[i]; %>  
       <tr>
       <%id=a.getItemid(); 
       	 webBid=a.getCurrentbid();%>
       <td><% out.print(a.getItemid()); %></td>
       <td><% out.print(a.getAuctionid()); %></td>
       <td><% out.print(a.getItemname()); %></td>
       <td><% out.print(a.getCatName()); %></td>
       <td><% out.print(a.getStartprice()); %></td>
       <td><% out.print(a.getCurrentbid()); %></td>
       </tr>
       </tbody>
   <% } %>
   </table>
</div>


<div class="container">

<center>
		<%
            String message = (String) request.getAttribute("message");
            if (message != null) {
            	if(message == "Successful Bid!!"){
            		out.println("<font color='green'>" + message + "</font>");
            	}else{
            		out.println("<font color='red'>" + message + "</font>");
            	}
            }
           %>
	</center>
      <form class="form-signin" action="PlaceBid" method="POST" align="center">
        <h3 class="form-signin-heading" align="center">Place Bid</h3>
        <label for="input" class="sr-only">Bid Amount</label>
        <input type="text" name="bid" class="form-control" placeholder="" >
        <input type="hidden" name="id" value="<%= id%>"><br> 
			<input type="hidden" value="<%= webBid%>" name=webBid /> 
        
        <button class="btn btn-lg btn-primary btn-block" type="submit">Place Bid</button>
      </form>

    </div>
    
    
    
    <div class="container">
  <h2>Bid History</h2>            
  <table class="table table-hover">
    <thead>
     <tr>
       <th>Bid Id</th>
       <th>Auction Id</th>
       <th>Bidder's Name</th>
       <th>Bid Amount</th>
       <th>Bid Time</th>
      </tr>
    </thead>
           <tbody>
       <% BidHistory[] bh = (BidHistory[]) request.getAttribute("bidHistory"); 
       for (int i = 0; i < bh.length; i++) {  BidHistory a = bh[i]; %>  
       <tr>
       <td><% out.print(a.getBidId()); %></td>
       <td><% out.print(a.getAuctionId()); %></td>
       <td><% out.print(a.getName()); %></td>
       <td><% out.print(a.getBidAmount()); %></td>
       <td><% out.print(a.getTime()); %></td>
       </tr>
       </tbody>
   <% } %>

   </table>
</div>



</body>
</html>

