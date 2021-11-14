package com.urmala99.project;

import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CourseFileService implements ICourseFileService{
    
    @Override
    public List<Student> readStudentsFromFile(String filepath) throws FileNotFoundException{
        File file = new File(filepath);
        List<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(file);
        while(sc.hasNext()){
            String[] row = sc.nextLine().split(" ");
            students.add(new Student(row[0], row[1]));
        } 
        sc.close();
        return students;
    }

    @Override
    public List<Course> readCoursesFromFile(String filepath) throws FileNotFoundException{
        File file = new File(filepath);
        List<Course> courses = new ArrayList<>();
        Scanner sc = new Scanner(file);
        while(sc.hasNext()){
            String[] row = sc.nextLine().split("--");
            /* Checking for online course*/
            if(row.length > 3){
                courses.add(new OnlineCourse(row[0], row[1], new ArrayList<>(), row[2]));
            }else {
                courses.add(new LocalCourse(row[0], row[1], new ArrayList<>(), row[2]));
            
            }
        }
        sc.close();
        return courses;
    }
}
