<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <% String message = (String) request.getAttribute("message"); %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="styles.css">
<meta charset="ISO-8859-1">
<title>Sign Up</title>
</head>
<body>
<div class="banner"><h1>Online Medical service</h1></div>
<h2>Sign Up Form</h2>
<% if (message!=null ){ %>
<h2 style="background-color:red"><%= message %></h2>
<%} %>
<form action="UserController" method="post">
 <div class="container">
 
    <label><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="username" required>

    <label><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>
    
    <label><b>Email ID</b></label>
    <input type="email" placeholder="Enter email id" name="email" required>
        
    <button type="submit" name="signup_submit"><b>Submit</b></button>
  </div>
</form>
<a href="index.jsp"><button style="background-color:blue;width: 45%;margin-left: 27.5%;"><b>Sign In</b></button></a>
</body>
</html>