package com.mar.model;

public class ChildBO {
    private int child_id;
    private String first_name;
    private String last_name;
    private int age;
    private String father_no;

    public ChildBO() {
        // no body
    }

    public ChildBO(String first_name, String last_name, int age, String father_no) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.father_no = father_no;
    }

    public ChildBO(int child_id, String first_name, String last_name, int age, String father_no) {
        this.child_id = child_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.father_no = father_no;
    }

    public int getChild_id() {
        return child_id;
    }

    public void setChild_id(int child_id) {
        this.child_id = child_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFather_no() {
        return father_no;
    }

    public void setFather_no(String father_no) {
        this.father_no = father_no;
    }
}
