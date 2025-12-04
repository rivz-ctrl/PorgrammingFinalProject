package org.reeves;

import java.util.ArrayList;
import java.util.Arrays;

public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private ArrayList<Integer> scores;
    private static int nextId = 1;

    /**
     * calculates the average for the assignment
     */
    void calcAssignment() {
    }

    /**
     * generates random scores for all students in an assignment
     */
    void generateRandomScore() {
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "assignmentId='" + assignmentId + '\'' +
                ", assignmentName='" + assignmentName + '\'' +
                ", weight=" + weight +
                '}';
    }
}
