package org.reeves;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
@EqualsAndHashCode
@Getter
@Setter
public class Student {
    private String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private ArrayList<Course> registeredCourses;
    private static int nextId = 1;

    public enum Gender {
        MALE, FEMALE;
    }

    public Student(String studentName, Gender gender, Address address, Department department) {
        this.studentName = studentName;
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.studentId = String.format("S%06d", nextId++);
        this.registeredCourses = new ArrayList<>();
    }

    /**
     * registers a course
     * 1) adds the course to the student's registeredCourses list
     * 2) adds the student to the course's registeredStudents list
     * 3) appends a null for the scores of each assignment of the course
     * if the course is already registered, directly returns false without adding anything
     * @param course the course to be registered
     * @return whether the student can be registered
     */

    // dont forget to make Course  and assignments (reminder: they are just placeholders for now)
    public boolean registerCourses(Course course) {
        if (course == null || registeredCourses.contains(course)) {
            return false;
        }
        registeredCourses.add(course);

        if (course.getRegisteredStudents().contains(this)) {
            course.getRegisteredStudents().add(this);
        }

        for (Assignment assignment : course.getAssignments()) {
            if (assignment.getScores().size() < course.getRegisteredStudents().size()) {
                assignment.getScores().add(null);
            }
        }

        return true;
    }

    /**
     * drops a course, removes the course from the student's registeredCourses list,
     * and remove the student from the course's registeredStudents list
     * if the course is not registered yet, directly returns false without removing anything
     * @param course the course to be dropped
     * @return whether the student's course can be dropped
     */
    public boolean dropCourse(Course course) {
        if (course == null || !getRegisteredCourses().contains(course)) {
            return false;
        }

        int idx = course.getRegisteredStudents().indexOf(this);
        registeredCourses.remove(course);
        course.getRegisteredStudents().remove(this);

        for (Assignment assignment : course.getAssignments()) {
            if (idx >= 0 && idx < assignment.getScores().size()) {
                assignment.getScores().remove(idx);
            }

        }
        return true;
    }

    public String toSimplifiedString() {
        return department.getDepartmentName() + ' ' + studentName + ' ' + studentId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", gender=" + gender +
                ", address=" + address +
                ", department=" + department +
                ", registeredCourses=" + registeredCourses.size() +
                '}';
    }
}
