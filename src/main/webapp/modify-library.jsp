<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JPA Tutorial</title>
</head>
<body>

<form action="./modify-library">
    <input type="hidden" id="libraryId" name="libraryId" value ="<%= request.getParameter("libraryId") %>">
    New Library Name: <input type="text" id="name" name="name" required="true">
    <input type="submit" value="Modify library!">
</form>

</body>
</html>
