package com.urmala99.project;

import java.util.List;


public class Course {
    protected String courseName;
    protected String teacherName;
    protected List<Student> studentList;
    private int id;
    private static int idCounter = 0;

    public Course(){
        this.id = idCounter++;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacherName() {
        return this.teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public long getId() {
        return this.id;
    }

    public List<Student> getStudentList() {
        return this.studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public boolean addStudentToCourse(Student student){
        if(this.studentList.contains(student)){
            return false;
        }else{
            this.studentList.add(student);
            return true;
        }
    }

    public void removeStudentFromCourse(Student student){
        if(this.studentList.contains(student)){
            this.studentList.remove(student);
        }
    }

}