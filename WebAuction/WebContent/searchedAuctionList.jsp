<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="controller.category.*"%>
<%@page import="model.category.*"%>
    <%@page import="controller.auction.*"%>
<%@page import="model.auction.*"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Khalid's Web Auction</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
  <h2>Your Searched List</h2>
  <p>Below are the auctions that come under your search criteria.</p>            
  <table class="table table-hover">
    <thead>
      <tr>
        <th>Item Id</th>
       <th>Auction Id</th>
       <th>Item Name</th>
       <th>Category</th>
       <th>Start Price</th>
       <th>Current Bid</th>
       <th>Action</th>
      </tr>
    </thead>
    <tbody>
       <% AuctionItem[] auc = (AuctionItem[]) request.getAttribute("auction"); for (int i = 0; i < auc.length; i++) {  AuctionItem a = auc[i]; %>  
       <tr>
       <td><% out.print(a.getItemid()); %></td>
       <td><% out.print(a.getAuctionid()); %></td>
       <td><% out.print(a.getItemname()); %></td>
       <td><% out.print(a.getCatName()); %></td>
       <td><% out.print(a.getStartprice()); %></td>
       <td><% out.print(a.getCurrentbid()); %></td>
<td><form action="AuctionOverview" method="post"> <input type="hidden" type="text" name="id" value=<% out.print(a.getItemid()); %> /> <input type="submit" value="Open"></form></td>
       </tr>
       </tbody>
       <!-- close the loop -->
   <% } %>
   <!-- close table --> 
   </table>
</div>

</body>
</html>

