<%--
  Created by IntelliJ IDEA.
  User: David Nogales
  Date: 5/16/2021
  Time: 6:03 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Modify Author</title>
    <link rel="stylesheet" href="css/css.css">
</head>
<body>

<form action="./modify-author">
    <input type="hidden" id="authorId" name="authorId" value ="<%= request.getParameter("authorId") %>">
    Author name: <input type="text" id="name" name="name" required="true">
    Author Country: <input type="text" id="country" name="country" required="true">
    <input type="submit" value="Modify author!">

</form>

</body>
</html>
