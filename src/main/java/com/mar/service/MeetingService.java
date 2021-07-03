package com.mar.service;

import com.mar.dao.MeetingDao;
import com.mar.model.Meeting;
import com.mar.model.MeetingBo;

import java.util.List;

public class MeetingService {
    private MeetingDao meetingDao;

    public MeetingService() {
        this.meetingDao = new MeetingDao();
    }

    public boolean saveMeetingToDB(Meeting meeting) {
        boolean isSaved = false;
        // convert program to userBo
        MeetingBo meetingBo = this.convetToMeetingBO(meeting);
        // insert the user to db
        isSaved = meetingDao.saveMeeting(meetingBo);
        return isSaved;
    }

    public Meeting getMeeting(int meetingId) {
        Meeting meeting = meetingDao.findMeeting(meetingId);
        return meeting;
    }

    public boolean removeMeeting(int meetingId) {
        return meetingDao.deleteMeeting(meetingId);
    }

    public List<Meeting> getAllMeetings() {
        return meetingDao.findAll();
    }

    public MeetingBo convetToMeetingBO(Meeting meeting) {
        MeetingBo meetingBo = new MeetingBo();
        meetingBo.setMeeting_title(meeting.getMeeting_title());
        meetingBo.setMeeting_desc(meeting.getMeeting_desc());
        meetingBo.setMeeting_date(java.sql.Date.valueOf(meeting.getMeeting_date().toLocalDate()));
        return meetingBo;
    }
}