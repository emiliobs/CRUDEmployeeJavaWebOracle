<%-- 
    Document   : add
    Created on : Oct 16, 2024, 3:48:18 PM
    Author     : Emilio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Employee</title>
    </head>
    <body>

    <center>
        <div>
            <h1>New Employee.</h1>
        </div>
        <hr/>
        <div>
            <form action="PeoplesController" method="POST">
                ID:<br>
                <input type="text" name="txtId"><br>
                Name:<br>
                <input type="text" name="txtName"><br>
                Email:<br>
                <input type="text" name="txtEmail" ><br>
                Phone:<br>
                <input type="text" name="txtPhone"><br><br>
                <input type="submit" name="action" value="Save">
            </form>
        </div>
    </center>
</body>
</html>
