<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JPA Tutorial</title>
    <link rel="stylesheet" href="css/css.css">
</head>
<body>

<form action="./create-edition">
    <input type="hidden" id="bookId" name="bookId" value ="<%= request.getParameter("bookId") %>">

    Release Year: <input type="date" id="year" name="year" required="true">
    Edition Description: <textarea id="desc" name="desc" style="resize: none" required="true"></textarea>
    <input type="submit" value="Create Edition!">
</form>

</body>
</html>
