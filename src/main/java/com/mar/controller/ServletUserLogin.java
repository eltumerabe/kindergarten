package com.mar.controller;

import com.mar.model.User;
import com.mar.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletUserLogin extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        UserService userService = new UserService();
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));
        User loginUser = userService.loginUser(user);
        if (null != loginUser) {
            if (loginUser.getRole().equals("user")) {
                request.setAttribute("user",loginUser);
                request.getRequestDispatcher("/WEB-INF/jsp/user-profile.jsp").forward(request,response);
            } else {
                request.getRequestDispatcher("/WEB-INF/jsp/gardian-dashboard.jsp").forward(request,response);
            }
        } else {
            request.setAttribute("msg","wrong user name or password");
            request.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(request,response);
        }
    }
}
