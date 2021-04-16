<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.ArrayList,com.isi.entity.Book,com.isi.Manager.BookManager,com.isi.controller.BookCartController"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="product.css">
<meta charset="ISO-8859-1">
<title>Product Page</title>
</head>
<body>
<% ArrayList<Book> bookList = (ArrayList<Book>) request.getAttribute("bookList"); %>
<div class="row">
<%for(Book book : bookList) { %>
  <div class="column" style="background-color:#ddd;">
  		<img src="Images/<%= book.getUrl() %>" alt="image" >
    <h2>Name : <%= book.getName() %></h2>
    <p>Article Number :<%= book.getId() %></p>
    <p>Price : <%= book.getPrice() %></p>
    <p>Author : <%= book.getAuthor() %></p>
    <p>Description : <%= book.getDescription() %></p>
    <a href=\JavaFinalProject\BookCartController?action=add&id=<%= book.getId() %>><button>ADD</button></a>
  </div>
  <% } %>
  <a href=\JavaFinalProject\BookCartController?action=cart><button>SHow the cart</button></a>
</div>
</body>
</html>