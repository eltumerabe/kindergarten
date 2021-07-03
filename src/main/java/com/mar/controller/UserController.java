package com.mar.controller;

import com.mar.constants.*;
import com.mar.model.User;
import com.mar.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UserController")
public class UserController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getMethod().equalsIgnoreCase("POST")) {
            String flag = request.getParameter(UserFormFlags.flag.toString());
            if (flag.equalsIgnoreCase(UserFormFlags.login.toString())) {
                doLogin(request, response);
            } else if (flag.equalsIgnoreCase(UserFormFlags.registration.toString())) {
                doRegistration(request, response);
            } else if (flag.equalsIgnoreCase(UserFormFlags.passwordreset.toString())) {
                doPasswordReset(request, response);
            }
        } else {
            String flag = request.getParameter(UserFormFlags.flag.toString());
            if (flag.equalsIgnoreCase(Navigations.resetpassword.toString())) {
                request.getRequestDispatcher("/WEB-INF/jsp/change-password.jsp").forward(request, response);
            }
            else if (flag.equalsIgnoreCase(Navigations.fresetpassword.toString())){
                request.getRequestDispatcher("/WEB-INF/jsp/father/change-password.jsp").forward(request, response);
            }
            else if (flag.equalsIgnoreCase(Navigations.fatherprofile.toString())){
                request.getRequestDispatcher("/WEB-INF/jsp/father/father-profile.jsp").forward(request, response);
            }
            else if(flag.equalsIgnoreCase(Navigations.logout.toString())){
                doLogout(request,response);
            }
        }
    }

    protected void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        UserService userService = new UserService();
        user.setEmail(request.getParameter(FormLogin.email.toString()));
        user.setPassword(request.getParameter(FormLogin.password.toString()));
        User loginUser = userService.loginUser(user);
        if (null != loginUser) {
            if (loginUser.getRole().equalsIgnoreCase(Roles.USER.toString())) {
                HttpSession session = request.getSession();
                session.setAttribute("user", loginUser);
                request.getRequestDispatcher("/WEB-INF/jsp/user-profile.jsp").forward(request, response);
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("user", loginUser);
                request.getRequestDispatcher("/WEB-INF/jsp/father/father-profile.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("msg", "wrong user name or password");
            request.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(request, response);
        }
    }
    protected void doLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        request.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(request,response);
    }


    protected void doRegistration(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserService();
        User user = new User();
        user.setUsername(request.getParameter(FormRegistration.username.toString()));
        user.setPassword(request.getParameter(FormRegistration.password.toString()));
        user.setEmail(request.getParameter(FormRegistration.email.toString()));
        user.setRole(request.getParameter(FormRegistration.role.toString()));
        boolean isSaved = userService.saveUserToDB(user);
        // if the registration success , then forward to dashboard
        if (isSaved) {
            request.getRequestDispatcher("/WEB-INF/jsp/user-profile.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/WEB-INF/jsp/registration.jsp").forward(request, response);
        }
    }

    protected void doPasswordReset(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserService();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");
        boolean isNewPassAndConfirmPass = this.validateNewPasswordAndConfirmedPassword(newPassword, confirmPassword);
        boolean isOldPassAndNewPass = this.validateEnteredOladPasswordWithOldPassword(user.getPassword(), oldPassword);
        if (isNewPassAndConfirmPass && isOldPassAndNewPass){
            boolean isUpdated = userService.modifyPassword(newPassword, user.getUserId());
            if (isUpdated) {
                // update the session
                User updatedUser = userService.getUser(user.getEmail());
                HttpSession newSession = request.getSession();
                newSession.setAttribute("user",updatedUser);
                request.setAttribute("msg", "password reset successfully");
                request.getRequestDispatcher("/WEB-INF/jsp/change-password.jsp").forward(request, response);
            } else {
                request.setAttribute("msg", "password reset failed");
                request.getRequestDispatcher("/WEB-INF/jsp/change-password.jsp").forward(request, response);
            }
        }
        else {
            request.setAttribute("msg", "New password and confirm password are not same");
            request.getRequestDispatcher("/WEB-INF/jsp/change-password.jsp").forward(request, response);
        }

    }

    private boolean validateEnteredOladPasswordWithOldPassword(String password, String newPassword) {
        return (password.equals(newPassword)) ? true : false;
    }

    private boolean validateNewPasswordAndConfirmedPassword(String newPassword, String confirmPassword) {
        return (newPassword.equals(confirmPassword)) ? true : false;
    }

}