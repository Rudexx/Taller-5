<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JSP Tutorial</title>

    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>

<h1>Library Manager</h1>

<button onclick="location.href='./form-library.jsp';">Create library</button>
<button onclick="location.href='./form-author.jsp';">Create author</button>

<h3>Libraries</h3>

<table id="librariesTbl">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    </tbody>
</table>

<h3>Books</h3>

<table id="books">
    <thead>
    <tr>
        <th>Book Id</th>
        <th>Author Name</th>
        <th>Title</th>
        <th>Isbn</th>
        <th>Genre</th>
        <th># Editions</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    </tbody>
</table>


<h3>Authors</h3>

<table id="authorsTbl">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th># Books</th>
        <th>Country</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    </tbody>
</table>

<script>

    function printTable(elementId, servlet, columns, actions = []) {

        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function() {
            if (xhr.readyState == 4) {
                var data = JSON.parse(xhr.responseText);

                var tbodyRef = document.getElementById(elementId).getElementsByTagName('tbody')[0];

                data.map(d => {

                    var newRow = tbodyRef.insertRow();

                    columns.map(c => {
                        var cell = newRow.insertCell();
                        var text = document.createTextNode(d[c]);
                        cell.appendChild(text);
                    });

                    if (actions.includes('create-book')) {
                        var cell = newRow.insertCell();
                        var action = document.createElement('button');
                        action.setAttribute('onclick', 'location.href="./form-book.jsp?authorId=' + d['authorId'] + '";');
                        var text = document.createTextNode('Create book');
                        action.appendChild(text);
                        cell.appendChild(action);
                    }
                    if (actions.includes('modify-author')){
                        var cell = newRow.insertCell();
                        var action = document.createElement('button');
                        action.setAttribute('onclick', 'location.href="./modify-author.jsp?authorId=' + d['authorId'] + '";');
                        var text = document.createTextNode('Modify author');


                        action.appendChild(text)
                        cell.appendChild(action);
                    }

                    if (actions.includes('delete-author')) {
                        var cell = newRow.insertCell();
                        var action = document.createElement('button');
                        action.setAttribute('onclick', 'location.href="./delete-author?authorId=' + d['authorId'] + '";');

                        var text = document.createTextNode('Delete author');

                        action.appendChild(text);
                        cell.appendChild(action);

                    }if (actions.includes('modify-book')) {

                        var cell = newRow.insertCell();
                        var action = document.createElement('button');
                        action.setAttribute('onclick', 'location.href="./modify-book.jsp?bookId=' + d['bookId'] + '";');

                        var text = document.createTextNode('Modify Book');

                        action.appendChild(text);
                        cell.appendChild(action);

                    }
                    if (actions.includes('delete-book')) {

                        var cell = newRow.insertCell();
                        var action = document.createElement('button');
                        action.setAttribute('onclick', 'location.href="./delete-book?info=' + d['bookId']+ " " +
                            d['authorId'] + '";');


                        var text = document.createTextNode('Delete book');

                        action.appendChild(text);
                        cell.appendChild(action);

                    }
                    if (actions.includes('delete-library')) {

                        var cell = newRow.insertCell();
                        var action = document.createElement('button');
                        action.setAttribute('onclick', 'location.href="./delete-library?libraryId=' + d['libraryId']+ '";');


                        var text = document.createTextNode('Delete library');

                        action.appendChild(text);
                        cell.appendChild(action);

                    }
                    if (actions.includes('modify-library')) {

                        var cell = newRow.insertCell();
                        var action = document.createElement('button');
                        action.setAttribute('onclick', 'location.href="./modify-library?libraryId=' + d['libraryId']+ '";');


                        var text = document.createTextNode('Modify Library');

                        action.appendChild(text);
                        cell.appendChild(action);

                    }

                });

            }
        }
        xhr.open('GET', '${pageContext.request.contextPath}/' + servlet, true);
        xhr.send(null);

    }

    // Printing libraries
    printTable(elementId = 'librariesTbl', servlet = 'list-libraries', columns = ['libraryId', 'name'] ,
        actions = ['delete-library' ,'modify-library' ]);



    // Printing authors
    printTable(elementId = 'authorsTbl', servlet = 'list-authors', columns = ['authorId', 'name', 'numBooks' , 'country'],
        actions = ['create-book', 'delete-author' , 'modify-author']);

    printTable(elementId = 'books', servlet = 'list-books', columns = ['bookId', 'authorName',
        'title', 'isbnNumber' ,'genre',
        'editionNumber' ] , actions = ['modify-book', 'delete-book']);

</script>

</body>
</html>