<%--
  Created by IntelliJ IDEA.
  User: David Nogales
  Date: 5/18/2021
  Time: 11:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JPA Tutorial</title>
</head>
<body>


<button></button>
<form action="./modify-library">
    <input type="hidden" id="libraryId" name="libraryId" value ="<%= request.getParameter("libraryId") %>">

    <input type="submit" value="Modify library!">
</form>

</body>
</html>
