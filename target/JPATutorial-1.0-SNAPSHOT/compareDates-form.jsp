<%--
  Created by IntelliJ IDEA.
  User: David Nogales
  Date: 5/19/2021
  Time: 5:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List Rents By Date</title>
    <link rel="stylesheet" href="css/css.css">

</head>
<body>
<h3>List Rents By Date</h3>


<form id="date" action="list-rentsByDate">
    <input type="hidden" id="email" name="email" value ="<%= request.getParameter("email") %>">
    From: <input type="date" id="year1" name="year1" required="true">
    to: <input type="date" id="year2" name="year2" required="true">

    <input type="submit" value="List Rents!">



</form>



</body>

</html>