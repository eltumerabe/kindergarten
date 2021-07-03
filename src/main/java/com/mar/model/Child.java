package com.mar.model;

public class Child {
    private int childId;
    private String firstName;
    private String lastName;
    private int age;
    private String fatherNo;

    public Child() {
        // no body
    }

    public Child(String firstName, String lastName, int age, String fatherNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.fatherNo = fatherNo;
    }

    public Child(int childId, String firstName, String lastName, int age, String fatherNo) {
        this.childId = childId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.fatherNo = fatherNo;
    }

    public int getChildId() {
        return childId;
    }

    public void setChildId(int childId) {
        this.childId = childId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFatherNo() {
        return fatherNo;
    }

    public void setFatherNo(String fatherNo) {
        this.fatherNo = fatherNo;
    }
}
