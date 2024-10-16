<%-- 
    Document   : edit
    Created on : Oct 16, 2024, 8:21:52 PM
    Author     : Emilio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit People</title>
    </head>
    <body>
    <center>
        <div>
            <h1>Edit People</h1>
        </div>
        <hr/>
        <div>
            <form action="PeoplesController" method="POST">
                ID:<br>
                <input type="text" name="txtId" value="${people.getId()}"><br>
                Name:<br>
                <input type="text" name="txtName" value="${people.getName()}"><br>
                Email:<br>
                <input type="text" name="txtEmail"  value="${people.getEmail()}"><br>
                Phone:<br>
                <input type="text" name="txtPhone" value="${people.getPhone()}"><br><br>
                <input type="submit" name="action" value="Update">
            </form>
        </div>
    </center>
</body>
</html>
