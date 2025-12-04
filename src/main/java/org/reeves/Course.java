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

    /**
     * checks if the sum of weights of all assignments of that course equals 100%
     * @return whether the sum of weights of assignments is valid
     */
    public boolean isAssignmentWeightValid() {

    }

    /**
     * adds a student to the student list of the course
     * adds a new null element to each assignment of this course
     * adds a new null element for the finalScores
     * @param student student to be added to student list
     * @return if the student can be registered
     */
    public boolean registerStudent (Student student) {

    }

    /**
     * calculates the weighted average score of a student
     * @return the student's weighted average
     */
    public int[] calcStudentsAverage() {

    }

    /**
     * adds a new assignment to the course
     * @param assignmentName name of the assignment
     * @param weight weight of the assignment
     * @param maxScore maximum score obtainable on the assignment
     * @return whether the new assignment can be added to the course
     */
    public boolean addAssignment(String assignmentName, double weight, int maxScore) {

    }

    /**
     * generates random scores for each assignment and student
     * calculates the final score for each student
     */
    public void generateScores() {

    }

    /**
     * displays the scores of a course in a table
     * (with assignment averages and student weighted average)
     */
    public void displayScores() {

    }


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
