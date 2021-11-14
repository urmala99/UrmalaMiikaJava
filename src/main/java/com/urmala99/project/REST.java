package com.urmala99.project;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class REST{
    @Autowired 
    CourseService courseService;

    @GetMapping("/students")
    public List<Student> getStudents() {
        return courseService.getStudents();
    }

    @GetMapping("/courses")
    public List<Course> getCourses(){
        return courseService.getCourses();
    }

    @GetMapping("/onlinecourses")
    public String getOnlineCourses(){
        List<Course> courses = courseService.getCourses();
        String onlineCourseInfo = "";
        for (Course course : courses) {
            if(course instanceof OnlineCourse){
                onlineCourseInfo += "<div>" + course.getCourseName() + "</div>";
            }
        }
        return onlineCourseInfo;

    }

    @GetMapping("/students/{id}")
    public String getStudentById(@PathVariable int id) {
        Student student = courseService.getStudentById(id);
        String studentInfo = "<h1>" + student.toString() + "</h1>";
        List<Course> courses = courseService.getCoursesOfStudent(id);
        for (Course course : courses) {
            studentInfo += "<div>" + course.getCourseName() + "</div>";                        
        }
        return studentInfo;
    }

    @GetMapping("/courses/{id}")
    public String getCourseById(@PathVariable int id) {
        Course course = courseService.getCourseById(id);
        String courseInfo = "<h1>" + course.getCourseName() + "</h1>";
        List<Student> students = course.getStudentList();
        for (Student student : students) {
            courseInfo += "<div>" + student.toString() + "</div>";                        
        }
        return courseInfo;
    }

    @PostMapping("/add")
    public String addStudentToCourse(@RequestBody Map<String, Object> jsonMap){
        long sid = (Long.parseLong(jsonMap.get("sid").toString()));
        long cid = (Long.parseLong(jsonMap.get("cid").toString()));
        boolean addedStudent = courseService.addStudentToCourse(sid, cid);
        if(addedStudent){
            Student student = courseService.getStudentById(sid);
            return student.toString() + " added to " + courseService.getCourseById(cid).getCourseName();
        }
        return "Failed to add student to the course";
    }
    

}








