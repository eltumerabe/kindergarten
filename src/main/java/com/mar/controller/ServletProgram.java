package com.mar.controller;

import com.mar.constants.Navigations;
import com.mar.model.Program;
import com.mar.service.ProgramService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ServletProgram extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    processRequest(request,response);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProgramService programService = new ProgramService();
        if (request.getMethod().equalsIgnoreCase("POST")){
            Program program = new Program();
            program.setProgramTitle(request.getParameter("title"));
            program.setProgramDescription(request.getParameter("desc"));
            boolean isSaved = programService.saveProgramToDB(program);
            if (isSaved){
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/add-programs.jsp");
                request.setAttribute("msg","Program added successfully");
                rd.forward(request,response);
            }
            else {
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/add-programs.jsp");
                request.setAttribute("msg","Failed to add the program");
                rd.forward(request,response);
            }
        }
        else {
            String param = request.getParameter("programId");
            String flag = request.getParameter("flag");
            List<Program> allPrograms = null;
            if (null != param){
                int programId = Integer.parseInt(param);
                boolean isRemoved = programService.removeProgram(programId);
                if (isRemoved){
                    allPrograms = programService.getAllPrograms();
                    request.setAttribute("msg", "Program removed successfully");
                    request.setAttribute("programs", allPrograms);
                    request.getRequestDispatcher("/WEB-INF/jsp/programs.jsp").forward(request, response);
                }
                else {
                    allPrograms = programService.getAllPrograms();
                    request.setAttribute("msg", "Failed to remove the program");
                    request.setAttribute("programs", allPrograms);
                    request.getRequestDispatcher("/WEB-INF/jsp/programs.jsp").forward(request, response);
                }
            }
            if (null != flag){
                if (flag.equalsIgnoreCase(Navigations.programs.toString())){
                    allPrograms = programService.getAllPrograms();
                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/programs.jsp");
                    request.setAttribute("programs",allPrograms);
                    rd.forward(request,response);
                }
                else if (flag.equalsIgnoreCase(Navigations.fprograms.toString())){
                    allPrograms = programService.getAllPrograms();
                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/father/programs.jsp");
                    request.setAttribute("programs",allPrograms);
                    rd.forward(request,response);
                }
                else if (flag.equalsIgnoreCase(Navigations.addprogram.toString())){
                    request.getRequestDispatcher("/WEB-INF/jsp/add-programs.jsp").forward(request, response);
                }
            }

        }
    }
}
