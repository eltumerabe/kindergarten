package com.mar.controller;

import com.mar.constants.AppHttpMethods;
import com.mar.constants.MeetingFormFlags;
import com.mar.constants.Navigations;
import com.mar.model.Meeting;
import com.mar.service.MeetingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet(name = "MeetingController")
public class MeetingController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MeetingService meetingService = new MeetingService();
        if (request.getMethod().equalsIgnoreCase(AppHttpMethods.post.toString())) {
            String meetingTitle = request.getParameter(MeetingFormFlags.meetingtitle.toString());
            String meetingDesc = request.getParameter(MeetingFormFlags.meetingdesc.toString());
            String meetingDate = request.getParameter(MeetingFormFlags.meetingdate.toString());
            Meeting meeting = new Meeting();
            LocalDateTime localDateTime = LocalDateTime.now();
            meeting.setMeeting_title(meetingTitle);
            meeting.setMeeting_desc(meetingDesc);
            meeting.setMeeting_date(localDateTime);
            boolean isSaved = meetingService.saveMeetingToDB(meeting);
            if (isSaved){
                request.setAttribute("msg","Meeting added successfully");
                request.getRequestDispatcher("/WEB-INF/jsp/add-meetings.jsp").forward(request,response);
            }
            else {
                request.setAttribute("msg","Failed to add the meeting");
                request.getRequestDispatcher("/WEB-INF/jsp/add-meetings.jsp").forward(request,response);

            }
        } else {
            List<Meeting> allMeetings = null;
            String flag = request.getParameter("flag");
            if (null != flag && flag.equalsIgnoreCase(Navigations.addmeeting.toString())){
                request.getRequestDispatcher("/WEB-INF/jsp/add-meetings.jsp").forward(request,response);
            }
            else if (null != flag && flag.equalsIgnoreCase(Navigations.meetings.toString())){
                allMeetings = meetingService.getAllMeetings();
                request.setAttribute("meetings",allMeetings);
                request.getRequestDispatcher("/WEB-INF/jsp/meetings.jsp").forward(request,response);
            }
            else if (null != flag && flag.equalsIgnoreCase(Navigations.fmeetings.toString())){
                allMeetings = meetingService.getAllMeetings();
                request.setAttribute("meetings",allMeetings);
                request.getRequestDispatcher("/WEB-INF/jsp/father/meetings.jsp").forward(request,response);
            }
            String param = request.getParameter("meetingId");
            if (null != param){
                int meetingId = Integer.parseInt(param);
                boolean isRemoved = meetingService.removeMeeting(meetingId);
                if (isRemoved){
                    allMeetings = meetingService.getAllMeetings();
                    request.setAttribute("msg", "meeting removed successfully");
                    request.setAttribute("meetings", allMeetings);
                    request.getRequestDispatcher("/WEB-INF/jsp/meetings.jsp").forward(request,response);
                }
                else {
                    allMeetings = meetingService.getAllMeetings();
                    request.setAttribute("msg", "Failed to remove the meeting");
                    request.setAttribute("meetings", allMeetings);
                    request.getRequestDispatcher("/WEB-INF/jsp/meetings.jsp").forward(request,response);
                }
            }
        }
    }
}