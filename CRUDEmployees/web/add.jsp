<%-- 
    Document   : add
    Created on : Oct 16, 2024, 3:48:18 PM
    Author     : Emilio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>New Employee</title>
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <style>
            body {
                padding: 20px;
            }
            .form-container {
                max-width: 500px;
                margin: 0 auto;
                padding: 20px;
                border: 1px solid #ccc;
                border-radius: 8px;
                background-color: #f9f9f9;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="form-container">
                <h1 class="text-center">New Employee</h1>
                <hr>
                <form action="PeoplesController" method="POST">
                    <div class="mb-3">
                        <label for="txtId" class="form-label">ID:</label>
                        <input type="text" id="txtId" name="txtId" class="form-control">
                    </div>
                    <div class="mb-3">
                        <label for="txtName" class="form-label">Name:</label>
                        <input type="text" id="txtName" name="txtName" class="form-control">
                    </div>
                    <div class="mb-3">
                        <label for="txtEmail" class="form-label">Email:</label>
                        <input type="email" id="txtEmail" name="txtEmail" class="form-control" >
                    </div>
                    <div class="mb-3">
                        <label for="txtPhone" class="form-label">Phone:</label>
                        <input type="tel" id="txtPhone" name="txtPhone" class="form-control" >
                    </div>
                    <div class="text-center">
                        <button type="submit" name="action" value="Save" class="btn btn-success">Save</button> |
                        <button type="submit" name="action" value="Back" class="btn btn-dark">Back</button>
                    </div>
                </form>
            </div>
        </div>

        <!-- Bootstrap JS -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
