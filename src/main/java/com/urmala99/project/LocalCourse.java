package com.urmala99.project;

import java.util.List;


public class LocalCourse extends Course {
    private String room;

    public LocalCourse(String courseName, String teacherName, List<Student> studentList, String room) {
        this.courseName = courseName;
        this.teacherName = teacherName;
        this.studentList = studentList;
        this.room = room;
    }

    public String getRoom() {
        return this.room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Override
    public boolean addStudentToCourse(Student student) {
        if(this.getStudentList().size() < 25) {
            return super.addStudentToCourse(student);
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return this.getCourseName() + " - " + this.getTeacherName() + " - " + this.getRoom();
    }
}

