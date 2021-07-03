package com.mar.model;

public class ProgramBO {
    private int program_id;
    private String program_title;
    private String program_description;

    public ProgramBO() {
        // no body
    }

    public ProgramBO(String program_title, String program_description) {
        this.program_title = program_title;
        this.program_description = program_description;
    }

    public ProgramBO(int program_id, String program_title, String program_description) {
        this.program_id = program_id;
        this.program_title = program_title;
        this.program_description = program_description;
    }

    public int getProgram_id() {
        return program_id;
    }

    public void setProgram_id(int program_id) {
        this.program_id = program_id;
    }

    public String getProgram_title() {
        return program_title;
    }

    public void setProgram_title(String program_title) {
        this.program_title = program_title;
    }

    public String getProgram_description() {
        return program_description;
    }

    public void setProgram_description(String program_description) {
        this.program_description = program_description;
    }
}
