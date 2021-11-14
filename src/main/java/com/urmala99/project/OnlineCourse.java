package com.urmala99.project;

import java.util.List;


public class OnlineCourse extends Course {
    private String address;
    
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public OnlineCourse(String courseName, String teacherName, List<Student> studentList, String address) {
        this.courseName = courseName;
        this.teacherName = teacherName;
        this.studentList = studentList;
        this.address = address;
    }
    @Override
    public String toString() {
        return this.getCourseName() + " - " + this.getTeacherName() + " - " + this.getAddress();
    }

    
}
