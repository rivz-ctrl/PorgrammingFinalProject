package org.reeves;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.reeves.util.Util;

import java.util.ArrayList;

@EqualsAndHashCode
@Getter
@Setter
public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private ArrayList<Assignment> assignments;
    private ArrayList<Student> registeredStudents;
    private ArrayList<Integer> finalScores;
    private static int nextId = 1;

    public Course(Department department, String courseName, double credits) {
        this.courseName = Util.toTitleCase(courseName);
        this.credits = credits;
        this.department = department;
        this.courseId = "C-" + department.getDepartmentId() + "-" + String.format("%02d", nextId++);
        this.registeredStudents = new ArrayList<>();
        this.assignments = new ArrayList<>();
        this.finalScores = new ArrayList<>();
    }

    /**
     * checks if the sum of weights of all assignments of that course equals 100%
     * @return whether the sum of weights of assignments is valid
     */
    // don't forget to write Weight method in assignment
    public boolean isAssignmentWeightValid() {
        double weightTotal = 0;
        for (Assignment assignment : assignments) {
            weightTotal += assignment.getWeight();
        }
        return weightTotal == 100;
    }

    /**
     * adds a student to the student list of the course
     * adds a new null element to each assignment of this course
     * adds a new null element for the finalScores
     * @param student student to be added to student list
     * @return if the student can be registered
     */
    public boolean registerStudent (Student student) {
        if (student == null || registeredStudents.contains(student)) {
            return false;
        }

        registeredStudents.add(student);
        finalScores.add(null);

        for (Assignment assignment : assignments) {
            while (assignment.getScores().size() < registeredStudents.size()) {
                assignment.getScores().add(null);
            }
        }
        return true;
    }

    /**
     * calculates the weighted average score of a student
     * @return the student's weighted average
     */
    public int[] calcStudentsAverage() {
        int numberOfStudents = registeredStudents.size();
        int[] weightedAverage = new int[numberOfStudents];

        for (int i = 0; i < numberOfStudents; i++) {
            double total = 0;
            for (Assignment assignment : assignments) {
                Integer score = assignment.getScores().get(i);
                if (score != null) {
                    total += score * assignment.getWeight() / 100.0;
                }
            }
            weightedAverage[i] = (int) total;
        }
        return weightedAverage;
    }

    /**
     * adds a new assignment to the course
     * @param assignmentName name of the assignment
     * @param weight weight of the assignment
     * @param maxScore maximum score obtainable on the assignment
     * @return whether the new assignment can be added to the course
     */
    public boolean addAssignment(String assignmentName, double weight, int maxScore) {
        for (Assignment assignment : assignments) {
            if (assignment.getAssignmentName().equals(assignmentName)) {
                return false;
            }
        }

        Assignment assignment = new Assignment(assignmentName, weight);
            for ( int i = 0; i < registeredStudents.size(); i++) {
                assignment.getScores().add(null);
        }
            assignments.add(assignment);
            return  true;
    }

    /**
     * generates random scores for each assignment and student
     * calculates the final score for each student
     */
    public void generateScores() {
        for (Assignment assignment : assignments) {
            assignment.generateRandomScore();;
            assignment.calcAssignmentAvg();;
        }

        int[] studentsAverages = calcStudentsAverage();

        finalScores.clear();
        for (int avg : studentsAverages) {
            finalScores.add(avg);
        }
    }

    /**
     * converts a course to a simple string
     * @return the simplified string
     */
    public String toSimplifiedString() {
        return  courseId + ' ' + courseName + ' ' + credits + ' ' + department.getDepartmentName();
    }

    /**
     * converts a course to a string and a line to show if the current is AssignmentWeightValid
     * @return a string containing : courseId, courseName, credits, department, assignments, registeredStudents(studentId, studentName, departmentName
     */
    public String toString() {
        return "Course = (" +
                "courseId=" + courseId + '\'' +
                ", courseName" + courseName + '\'' +

                ", credits=" + credits + '\'' +
                ", department=" + department + '\'' +
                ", assignments=" + assignments + '\'' +
                ", registeredStudents=" + registeredStudents +
                ')';

    }

    /**
     * displays the scores of a course in a table (with assignment averages and student weighted average)
     */
    public void displayScores() {
        int numOfStudents = registeredStudents.size();
        int numOfAssignments = assignments.size();
        int[] finalAverages = calcStudentsAverage();

        String[][] table = new String[numOfStudents + 2][numOfAssignments + 2];

        table[0][0] = "Student Name";
        for (int j = 0; j < numOfAssignments; j++) {
            table[0][j+1] = assignments.get(j).getAssignmentName();
        }
        table[0][numOfAssignments + 1] = "Final Score";

        for (int i = 0; i < numOfStudents; i++) {
            table[i + 1][0] = registeredStudents.get(i).getStudentName();

            for (int j = 0; j < numOfAssignments; j++) {
                Integer score = assignments.get(j).getScores().get(i);
                table[i+1][j+1] = (score == null ? "0" : score.toString());
            }
            table[i+1][numOfAssignments + 1] = Integer.toString(finalAverages[i]);
        }

        table[numOfStudents+1][0] = "Average";
        for(int j = 0; j < numOfAssignments; j++) {
            assignments.get(j).calcAssignmentAvg();
            table[numOfStudents +  1][j + 1] = String.format("%.2f", assignments.get(j).getAverageScore());
        }
        table[numOfStudents+1][numOfAssignments+1] = "N/A";

        System.out.println("\n Course: " + courseName + "(" + courseId + ")\n");

        int cellWidth = "Student Name".length();
        for (Student student : registeredStudents) {
            if (student.getStudentName().length() > cellWidth) {
                cellWidth = student.getStudentName().length();
            }
        }
        cellWidth += 5;

        for(int rowIndex = 0; rowIndex < table.length; rowIndex++) {
            for (int colIndex = 0; colIndex < table[rowIndex].length; colIndex++) {
                String cell = table[rowIndex][colIndex] == null ? "N/A" : table[rowIndex][colIndex];
                if (colIndex == 0) {
                    System.out.printf("%-" + cellWidth + "s", cell);
                } else {
                    System.out.printf("%-10s", cell);
                }
            }
            System.out.println();
        }
    }
}
