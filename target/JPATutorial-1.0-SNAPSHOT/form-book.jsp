<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JPA Tutorial</title>
    <link rel="stylesheet" href="css/css.css">
</head>
<body>

<form action="./create-book">
    <input type="hidden" id="authorId" name="authorId" value ="<%= request.getParameter("authorId") %>">
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
    Release Year: <input type="date" id="year" name="year" required="true">
    Edition Description: <textarea id="desc" name="desc" style="resize: none" required="true"></textarea>
    <input type="submit" value="Create book!">
</form>

</body>
</html>
