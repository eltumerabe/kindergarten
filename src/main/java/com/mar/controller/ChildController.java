package com.mar.controller;

import com.mar.constants.ChildFormFlags;
import com.mar.constants.Navigations;
import com.mar.model.Child;
import com.mar.service.ChildService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ChildController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ChildService childService = new ChildService();
        if (request.getMethod().equalsIgnoreCase("POST")) {
            Child child = new Child();
            child.setFirstName(request.getParameter(ChildFormFlags.firstname.toString()));
            child.setLastName(request.getParameter(ChildFormFlags.lastname.toString()));
            child.setAge(Integer.parseInt(request.getParameter(ChildFormFlags.age.toString())));
            child.setFatherNo(request.getParameter(ChildFormFlags.mobilenumber.toString()));
            boolean isSaved = childService.saveChildToDB(child);
            if (isSaved) {
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/add-childs.jsp");
                request.setAttribute("msg", "Child added successfully");
                rd.forward(request, response);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/add-childs.jsp");
                request.setAttribute("msg", "Failed to add child");
                rd.forward(request, response);
            }
        } else {
            String flag = request.getParameter("flag");
            String removedChild = request.getParameter("childId");
            if (null != flag && flag.equalsIgnoreCase("childs")) {
                List<Child> allChilds = childService.getAllChilds();
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/childs.jsp");
                request.setAttribute("childs", allChilds);
                rd.forward(request, response);

            }
            if (null != removedChild) {
                int userId = Integer.parseInt(removedChild);
                boolean isRemoved = childService.removeChild(userId);
                List<Child> allChilds = null;
                if (isRemoved) {
                    // update the session
                    allChilds = childService.getAllChilds();
                    request.setAttribute("msg", "Child removed successfully");
                    request.setAttribute("childs", allChilds);
                    request.getRequestDispatcher("/WEB-INF/jsp/childs.jsp").forward(request, response);
                }
                else {
                    allChilds = childService.getAllChilds();
                    request.setAttribute("msg", "Child deletion failed");
                    request.setAttribute("childs", allChilds);
                    request.getRequestDispatcher("/WEB-INF/jsp/childs.jsp").forward(request,response);
                }
            }
        }
    }
}