package org.reeves;

import java.util.ArrayList;

public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private ArrayList<Assignment> assignments;
    private ArrayList<Student> registeredStudents;
    private static int nextId = 1;

    public String toSimplifiedStringg() {
        "}";
    }

    @Override
    public String toString {
        String message = "Student{"
        "name=" + name + '\'' +
                ", course=";
        for (Student student : students) {
            message += student.toSimplifiedStringg();
        }

        return message;
    }

    public list<Student> getStudents() {

    }
}
