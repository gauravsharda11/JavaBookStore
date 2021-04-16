<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="styles.css">
<meta charset="ISO-8859-1">
<title>Category Page</title>
</head>
<body>
<div class="banner"><h1>Online Medical service</h1></div>
<br><br>
<p>The select Category you wish to explore books</p>

<form action="CategoryController" method="post">
  <label >Choose a Category :</label>
  <select name="category" id="category">
    <option value="Comic">Comic Books</option>
    <option value="Super Heroes">Super Hero Books</option>
    <option value="Horror">Horror Books</option>
    <option value="Biography">Biographies</option>
  </select>
  <br><br>
  <input type="submit" value="Submit">
</form>
</body>
</html>