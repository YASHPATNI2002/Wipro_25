package com.wipro.springdemo.beans;

public class College {

    private String collegeName;
    private Department department;

    public College() {
        // no-arg constructor
    }

    public College(String collegeName, Department department) {
        this.collegeName = collegeName;
        this.department = department;
    }

    // Getters and setters
    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "College [collegeName=" + collegeName + ", department=" + department + "]";
    }
}
