<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JPA Tutorial</title>
</head>
<body>

<form action="./modify-book">
    <input type="hidden" id="bookId" name="bookId" value ="<%= request.getParameter("bookId") %>">
    Book title: <input type="text" id="title" name="title" required="true">
    <br />
    Book ISBN: <input type="text" id="isbn" name="isbn" required="true">
    <br />
    Book Genre: <select id="genre" name="genre">
    <option value="Fantasy">Fantasy</option>
    <option value="Sci-Fi">Sci-Fi</option>
    <option value="Mystery">Mystery</option>
    <option value="Thriller">Thriller</option>
    <option value="Romance">Romance</option>
    <option value="Westerns">Westerns</option>
    <option value="Dystopian">Dystopian</option>
    <option value="Contemporary">Contemporary</option>
</select>

    <input type="submit" value="Modify book!">
</form>

</body>
</html>
