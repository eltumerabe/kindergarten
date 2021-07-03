package com.mar.model;

public class Program {
    private int programId;
    private String programTitle;
    private String programDescription;

    public Program() {
        // no body
    }

    public Program(String programTitle, String programDescription) {
        this.programTitle = programTitle;
        this.programDescription = programDescription;
    }

    public Program(int programId, String programTitle, String programDescription) {
        this.programId = programId;
        this.programTitle = programTitle;
        this.programDescription = programDescription;
    }

    public int getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }

    public String getProgramTitle() {
        return programTitle;
    }

    public void setProgramTitle(String programTitle) {
        this.programTitle = programTitle;
    }

    public String getProgramDescription() {
        return programDescription;
    }

    public void setProgramDescription(String programDescription) {
        this.programDescription = programDescription;
    }
}
