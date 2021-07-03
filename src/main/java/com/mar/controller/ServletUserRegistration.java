package com.mar.controller;

import com.mar.model.User;
import com.mar.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletUserRegistration extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserService();
        User user = new User();
        user.setUsername(request.getParameter("userName"));
        user.setPassword(request.getParameter("password"));
        user.setEmail(request.getParameter("email"));
        user.setRole(request.getParameter("role"));
        boolean isSaved = userService.saveUserToDB(user);
        // if the registration success , then forward to dashboard
        if (isSaved) {
            request.getRequestDispatcher("/WEB-INF/jsp/user-dashboard.jsp").forward(request, response);
        }
    }
}
