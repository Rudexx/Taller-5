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
    <title>Create Rent</title>
    <link rel="stylesheet" href="css/css.css">
</head>
<body>

<form action="./create-rent">
    <input type="hidden" id="email" name="email" value ="<%= request.getParameter("email") %>">
    ¿Which Edition would you want to Rent?: <select id="editions" name="editions"></select>

    <input type="submit" value="Modify Customer!">

</form>
<script>
    function printTable(columns) {
        var xhr2 = new XMLHttpRequest();
        xhr2.onreadystatechange = function() {
            if (xhr2.readyState == 4) {
                var data = JSON.parse(xhr2.responseText);

                var select = document.getElementById("editions");
                console.log(select);

                data.map(d => {

                    var opt = document.createElement('option');
                    columns.map(c => {
                        opt.appendChild( document.createTextNode(d[c] + "     "));
                        opt.value =  opt.value + d[c] +" " ;
                        select.appendChild(opt);
                    });



                });


            }
        }
        xhr2.open('GET', '${pageContext.request.contextPath}/' + "list-editions", true);
        xhr2.send(null);
    }
    printTable(columns = ['editionId', 'description',
        'bookName',  'date']);


</script>

</body>

</html>
