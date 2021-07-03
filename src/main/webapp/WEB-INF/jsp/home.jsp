<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 4/30/2020
  Time: 11:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>KINDERGARTEN</title>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container" style="width: 50%;height: 50%;margin-top: 80px">
    <div class="card">
        <div class="container" style="width: 50%;height: 50%;align-content: center">
            <h4 class="card-title">Login In</h4>
            <p class="card-text">Please provide your valid username and password.</p>
            <div class="card-content">
                <form action="UserController" method="post">
                    <div class="form-group">
                        <label for="register" class="mr-sm-2">Don't have an account?</label>
                        <a href="jspRegistration">Register here</a>
                    </div>
                    <c:if test="${not empty msg}">
                        <div class="form-group">
                            <label for="register" style="color: red" class="mr-sm-2">${msg}</label>
                        </div>
                    </c:if>
                    <div class="form-group">
                        <input type="text" class="form-control mb-2 mr-sm-2" id="email" name="email"
                               placeholder="Email">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control mb-2 mr-sm-2" id="password" name="password"
                               placeholder="Password">
                    </div>
                    <div class="form-group">
                        <input type="hidden" class="form-control mb-2 mr-sm-2" id="flag" name="flag" value="login">
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary btn-block mb-2 mr-sm-2">Login</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</div>
</body>
</html>