package com.mar.model;

import java.sql.Date;

public class MeetingBo {
    private int meeting_id;
    private String meeting_title;
    private String meeting_desc;
    private Date meeting_date;

    public MeetingBo() {
        // no body
    }

    public MeetingBo(String meeting_title, String meeting_desc, Date meeting_date) {
        this.meeting_title = meeting_title;
        this.meeting_desc = meeting_desc;
        this.meeting_date = meeting_date;
    }

    public MeetingBo(int meeting_id, String meeting_title, String meeting_desc, Date meeting_date) {
        this.meeting_id = meeting_id;
        this.meeting_title = meeting_title;
        this.meeting_desc = meeting_desc;
        this.meeting_date = meeting_date;
    }

    public int getMeeting_id() {
        return meeting_id;
    }

    public void setMeeting_id(int meeting_id) {
        this.meeting_id = meeting_id;
    }

    public String getMeeting_title() {
        return meeting_title;
    }

    public void setMeeting_title(String meeting_title) {
        this.meeting_title = meeting_title;
    }

    public String getMeeting_desc() {
        return meeting_desc;
    }

    public void setMeeting_desc(String meeting_desc) {
        this.meeting_desc = meeting_desc;
    }

    public Date getMeeting_date() {
        return meeting_date;
    }

    public void setMeeting_date(Date meeting_date) {
        this.meeting_date = meeting_date;
    }
}
