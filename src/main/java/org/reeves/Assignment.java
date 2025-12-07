package org.reeves;

import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private ArrayList<Integer> scores;
    private static int nextId = 1;

    public Assignment(String assignmentName, double weight) {
        this.assignmentId = "Assignment-" + nextId++;
        this.assignmentName = assignmentName;
        this.weight = 100;
        this.scores = new ArrayList<>();
    }

    /**
     * calculates the average for the assignment
     */
    public void calcAssignmentAvg() {
        int sum = 0;
        int count = 0;
        for (Integer score : scores) {
            if (score != null) {
                sum += score;
                count++;
            }
        }
        int assignmentAvg = sum / count;
    }
// does range [0, 10] exclude or include 10
    /**
     * generates random scores for all students in an assignment
     */
    public void generateRandomScore() {
        Random random = new Random();

        for (int i = 0; i < scores.size(); i++) {
            int rando = random.nextInt(11);
            int score;

            // do I need to add the next score with the previous one like in taxes
            if (rando == 0) {
                score = random.nextInt(60);
            } else if (rando == 1 || rando == 2) {
                score = random.nextInt(70);
            } else if (rando == 3 || rando == 4 ) {
                score = random.nextInt(80);
            } else if (rando == 5 || rando == 6 || rando == 7 || rando == 8) {
                score = random.nextInt(90);
            } else {
                score = random.nextInt(100);
            }

            scores.add(score);
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
