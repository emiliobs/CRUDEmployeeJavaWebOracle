<%-- 
    Document   : index
    Created on : Oct 16, 2024, 2:38:57 PM
    Author     : Emilio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>People</title>
    </head>
    <body>
    <center>
        <div>
            <h1>Peoples List.</h1>
            <form action="PeoplesController" method="POST">
                <input type="submit" name="action" value="List">
                <input type="submit" name="action" value="Add">
            </form>
            <hr/>
        </div>
        <div>
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>FULL NAME</th>
                        <th>EMAIL</th>
                        <th>PHONE</th>
                        <th>ACTIONS</th>
                    </tr>
                </thead>               
                <tbody>
                    <c:forEach var="people" items="${peoples}">
                        <tr>
                            <td>${people.getId()}</td>
                            <td>${people.getName()}</td>
                            <td>${people.getEmail()}</td>
                            <td>${people.getPhone()}</td>
                            <td>
                                <form action="PeoplesController" method="POST">
                                    <input type="hidden" name="id" value="${people.getId()}">
                                    <input type="submit" name="action" value="Edit">
                                    <input type="submit" name="action" value="Delete">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

        </div>
    </center>
</body>
</html>