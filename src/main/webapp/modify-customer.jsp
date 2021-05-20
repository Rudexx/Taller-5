<%--
  Created by IntelliJ IDEA.
  User: David Nogales
  Date: 5/19/2021
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Modify Customer</title>
    <link rel="stylesheet" href="css/css.css">
</head>
<body>

<form action="./modify-customer">
    <input type="hidden" id="oldEmail" name="oldEmail" value ="<%= request.getParameter("email") %>">
    First Name: <input type="text" id="firstN" name="firstN" required="true">
    Last Name: <input type="text" id="lastN" name="lastN" required="true">
    Gender: <select id="gender" name="gender">
    <option value="Male">Male</option>
    <option value="Female">Female</option>
    <option value="Other">Other</option>
    </select>
    Age: <input type="number" required="true" id="age" name="age" >
    <input type="submit" value="Modify Customer!">

</form>

</body>
</html>

