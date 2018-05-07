<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="controller.category.*"%>
<%@page import="model.category.*"%>
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

<center>
		<%
            String message = (String) request.getAttribute("message");
            if (message != null) {
                out.println("<font color='red'>" + message + "</font><br></br>");
            }
           %>
	</center>


      <form class="form-signin" action="LoginController" method="POST">
        <h2 class="form-signin-heading" align="center">Log in</h2>
        <p align="center" class="text-danger">Note: You must be logged in before you can place a bid on any auction.</p>
        <label for="input" class="sr-only">Username</label>
        <input type="text" name="username" class="form-control" placeholder="Username" required="true" autofocus="">
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name="password" class="form-control" placeholder="Password" required="true">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>

    </div>

</body>
</html>
