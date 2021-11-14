package com.urmala99.project;

import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

@Service
public class CourseService implements ICourseService {
    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();
    CourseFileService fileService = new CourseFileService();

    public CourseService(){
        try{
            this.students = fileService.readStudentsFromFile("students.txt");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try{
            this.courses = fileService.readCoursesFromFile("courses.txt");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Student> getStudents() {
        return students;
    }

    @Override
    public List<Course> getCourses() {
        return courses;
    }

    @Override
    public Student getStudentById(long studentId){
        for (Student student : this.students){
            if(student.getId() == studentId){
                return student;
            }
        }
        return null;
    }

    @Override
    public Course getCourseById(long courseId) {
        for (Course course : this.courses){
            if(course.getId()==courseId){
                return course;
            }
        }
        return null;
    }
    
    @Override
    public List<Course> getCoursesOfStudent(long studentId){
        Student student = getStudentById(studentId);
        List<Course> studentCourses = new ArrayList<Course>();
        for (Course course : this.courses){
            if(course.getStudentList().contains(student)){
                studentCourses.add(course);
            }
        }
        return studentCourses;
    }

    @Override
    public boolean addStudentToCourse(long studentId, long courseId){
        Student student = getStudentById(studentId);
        for (Course course : this.courses) {
            if(course.getId()==courseId)
                return course.addStudentToCourse(student);
        }
        return false;
    }
}

