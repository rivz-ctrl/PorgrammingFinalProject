package org.reeves;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

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
    public void calcAssignmentAvg() {
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        double assignmentAvg = sum / (double) scores.size();
    }

    /**
     * generates random scores for all students in an assignment
     */
    public void generateRandomScore() {
        Random random = new Random();

        for (int i = 0; i < scores.size(); i++) {
            int num = random.nextInt(0,10);
            if (num == 0) {
                int score = random.nextInt(0, 60);
            } else if (num == 1 || num == 2) {
                int score = random.nextInt(60, 70);
            } else if (num == 3 || num == 4 ) {
                int score = random.nextInt(70, 80);
            } else if (num == 5 || num == 6 || num == 7 || num == 8) {
                int score = random.nextInt(80, 90);
            } else {
                int score = random.nextInt(90, 100);
            }
        }
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
