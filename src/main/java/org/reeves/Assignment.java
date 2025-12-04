package org.reeves;

import java.util.ArrayList;
import java.util.Arrays;

public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private ArrayList<Integer> scores;
    private static int nextId = 1;

    public Assignment(String assignmentName, double weight, int students) {
        this.assignmentId = "Assignment-" + nextId++;
        this.assignmentName = assignmentName;
        this.weight = 100;
        this.scores = new ArrayList<>();

        for (int i = 0; i < students; i++) {
            scores.add(0);
        }
    }

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
