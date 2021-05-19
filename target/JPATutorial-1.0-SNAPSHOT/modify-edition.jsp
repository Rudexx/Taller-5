<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JPA Tutorial</title>
    <link rel="stylesheet" href="css/css.css">
</head>
<body>

<form action="./modify-edition">
    <input type="hidden" id="editionId" name="editionId" value ="<%= request.getParameter("editionId") %>">

    Release Date: <input type="date" id="year" name="year" required="true">
    Edition Description: <textarea id="desc" name="desc" style="resize: none" required="true"></textarea>
    <input type="submit" value="Modify Edition!">
</form>

</body>
</html>
