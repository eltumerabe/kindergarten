<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 4/30/2020
  Time: 11:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
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
            <h4 class="card-title">Registration Form</h4>
            <p class="card-text">Please fill in all the fields in order to register in the application.</p>
            <div class="card-content">
                <form action="UserController" method="post" class="needs-validation" novalidate>
                    <div class="form-group">
                        <label for="register" class="mr-sm-2">have an account?</label>
                        <a href="jspHome">Sign In here</a>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control mb-2 mr-sm-2" id="userName" name="username"
                               placeholder="Username">
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control mb-2 mr-sm-2" id="email" name="email"
                               placeholder="Email">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control mb-2 mr-sm-2" id="password" name="password"
                               placeholder="Password">
                    </div>
                    <div class="form-group">
                        <select name="role" id="role" class="form-control mb-2 mr-sm-2">
                            <option value="user">User</option>
                            <option value="father">Father</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <input type="hidden" class="form-control mb-2 mr-sm-2" id="flag" name="flag" value="registration">
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary btn-block mb-2 mr-sm-2">Submit</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</div>
</body>
</html>