<%-- 
    Document   : index
    Created on : Oct 16, 2024, 2:38:57 PM
    Author     : Emilio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>People</title>
        <!-- Assuming Bootstrap is linked -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <style>
            body {
                padding: 20px;
            }
            table {
                margin-top: 20px;
            }
            .btn-actions {
                display: flex;
                gap: 10px;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="text-center">
                <h1>People's List</h1>
                <form action="PeoplesController" method="POST" class="d-inline-flex gap-2">
                    <button type="submit" name="action" value="List" class="btn btn-primary">List</button>
                    <button type="submit" name="action" value="Add" class="btn btn-success">Add</button>
                </form>
                <hr/>
            </div>

            <table class="table table-bordered table-hover">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Full Name</th>
                        <th>Email</th>
                        <th>Phone</th>
                        <th>Actions</th>
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
                                <form action="PeoplesController" method="POST" class="btn-actions">
                                    <input type="hidden" name="id" value="${people.getId()}">
                                    <button type="submit" name="action" value="Edit" class="btn btn-warning">Edit</button>
                                    <button type="submit" name="action" value="Delete" class="btn btn-danger">Delete</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <!-- Bootstrap JS -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
