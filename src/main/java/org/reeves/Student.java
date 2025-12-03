package org.reeves;

import java.util.ArrayList;

public class Student {
    private String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private ArrayList<Course> registeredCourses;
    private static int nextId;

    public enum Gender {
        MALE, FEMALE;
    }

    /**
     * registers a course
     * 1) adds the course to the student's registeredCourses lsit
     * 2) adds the student to the course<s registeredStudents list
     * 3) appends a null for the scores of each assignment of the course
     * if the course is already registered, directly returns false without adding anything
     * @param course the course to be registered
     * @return whether the student can be registered
     */
    public boolean registerCourses(Course course) {
    }
}
