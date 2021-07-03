package com.mar.dao;

import com.mar.model.Program;
import com.mar.model.ProgramBO;

import javax.xml.stream.FactoryConfigurationError;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProgramDao {
    private static final String INSERT_PROGRAM = "INSERT INTO programs (program_title,program_description) VALUES (?,?)";
    private static final String GET_PROGRAM = "SELECT * FROM programs WHERE program_id = ?";
    private static final String GET_ALL_PROGRAM = "SELECT * FROM programs";
    private static final String DELETE_PROGRAM = "DELETE FROM programs WHERE program_id = ?";

    private Connection connection;

    public ProgramDao() {
        this.connection = ConnectionFactory.getConnection();
    }

    public boolean saveProgram(ProgramBO programBO) {
        boolean isSaved = false;
        if (null == connection) {
            this.connection = ConnectionFactory.getConnection();
        }
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_PROGRAM);
            ps.setString(1, programBO.getProgram_title());
            ps.setString(2, programBO.getProgram_description());
            int i = ps.executeUpdate();
            if (i != 0) {
                isSaved = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSaved;
    }

    public Program findProgram(int programId) {
        Program program = null;
        if (null != connection) {
            this.connection = ConnectionFactory.getConnection();
        }
        try {
            PreparedStatement ps = connection.prepareStatement(GET_PROGRAM);
            ps.setInt(1,programId);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                program = this.getProgram(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return program;
    }
    public boolean deleteProgram(int programId){
        boolean isDeleted = false;
        if (null != connection){
            this.connection = ConnectionFactory.getConnection();
        }
        try {
            PreparedStatement ps = this.connection.prepareStatement(DELETE_PROGRAM);
            ps.setInt(1,programId);
            int i = ps.executeUpdate();
            if (i != 0){
                isDeleted = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDeleted;
    }

    public List<Program> findAll() {
        List<Program> programs = new ArrayList<Program>();
        if (null == connection) {
            this.connection = ConnectionFactory.getConnection();
        }

        try {
            PreparedStatement ps = connection.prepareStatement(GET_ALL_PROGRAM);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Program program = this.getProgram(resultSet);
                programs.add(program);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return programs;
    }

    public Program getProgram(ResultSet resultSet) {
        Program program = new Program();
        try {
            program.setProgramId(resultSet.getInt("program_id"));
            program.setProgramTitle(resultSet.getString("program_title"));
            program.setProgramDescription(resultSet.getString("program_description"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return program;
    }
}
