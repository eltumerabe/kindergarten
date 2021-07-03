package com.mar.service;

import com.mar.dao.ProgramDao;
import com.mar.model.Program;
import com.mar.model.ProgramBO;

import java.util.List;

public class ProgramService {
    private ProgramDao programDao;

    public ProgramService() {
        this.programDao = new ProgramDao();
    }

    public boolean saveProgramToDB(Program program) {
        boolean isSaved = false;
        // convert program to userBo
        ProgramBO programBO = this.convetToProgramBO(program);
        // insert the user to db
        isSaved = programDao.saveProgram(programBO);
        return isSaved;
    }

    public Program getProgram(int programId) {
        Program program = programDao.findProgram(programId);
        return program;
    }
    public boolean removeProgram(int programId){
        return programDao.deleteProgram(programId);
    }

    public List<Program> getAllPrograms() {
        List<Program> programs = programDao.findAll();
        return programs;
    }

    public ProgramBO convetToProgramBO(Program program) {
        ProgramBO programBO = new ProgramBO();
        programBO.setProgram_title(program.getProgramTitle());
        programBO.setProgram_description(program.getProgramDescription());
        return programBO;
    }
}
