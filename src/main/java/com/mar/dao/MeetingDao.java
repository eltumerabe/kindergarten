package com.mar.dao;

import com.mar.model.Meeting;
import com.mar.model.MeetingBo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MeetingDao {
    private static final String INSERT_MEETING = "INSERT INTO meetings (meeting_title,meeting_desc,meeting_date) VALUES (?,?,?)";
    private static final String GET_MEETING = "SELECT * FROM meetings WHERE meeting_id = ?";
    private static final String GET_ALL_MEETINGS = "SELECT * FROM meetings";
    private static final String DELETE_MEETING = "DELETE FROM meetings WHERE meeting_id = ?";

    private Connection connection;

    public MeetingDao() {
        this.connection = ConnectionFactory.getConnection();
    }

    public boolean saveMeeting(MeetingBo meetingBo) {
        boolean isSaved = false;
        if (null == connection) {
            this.connection = ConnectionFactory.getConnection();
        }
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_MEETING);
            ps.setString(1, meetingBo.getMeeting_title());
            ps.setString(2, meetingBo.getMeeting_desc());
            ps.setDate(3,meetingBo.getMeeting_date());
            int i = ps.executeUpdate();
            if (i != 0) {
                isSaved = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSaved;
    }

    public Meeting findMeeting(int meetingId) {
        Meeting meeting = null;
        if (null != connection) {
            this.connection = ConnectionFactory.getConnection();
        }
        try {
            PreparedStatement ps = connection.prepareStatement(GET_MEETING);
            ps.setInt(1,meetingId);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                meeting = this.getMeeting(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return meeting;
    }
    public boolean deleteMeeting(int meetingId){
        boolean isDeleted = false;
        if (null != connection){
            this.connection = ConnectionFactory.getConnection();
        }
        try {
            PreparedStatement ps = this.connection.prepareStatement(DELETE_MEETING);
            ps.setInt(1,meetingId);
            int i = ps.executeUpdate();
            if (i != 0){
                isDeleted = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDeleted;
    }

    public List<Meeting> findAll() {
        List<Meeting> meetings = new ArrayList<Meeting>();
        if (null == connection) {
            this.connection = ConnectionFactory.getConnection();
        }

        try {
            PreparedStatement ps = connection.prepareStatement(GET_ALL_MEETINGS);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Meeting meeting = this.getMeeting(resultSet);
                meetings.add(meeting);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return meetings;
    }

    public Meeting getMeeting(ResultSet resultSet) {
        Meeting meeting = new Meeting();
        try {
           meeting.setMeeting_id(resultSet.getInt("meeting_id"));
           meeting.setMeeting_title(resultSet.getString("meeting_title"));
           meeting.setMeeting_desc(resultSet.getString("meeting_desc"));
           meeting.setMeeting_date(resultSet.getTimestamp("meeting_date").toLocalDateTime());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return meeting;
    }
}