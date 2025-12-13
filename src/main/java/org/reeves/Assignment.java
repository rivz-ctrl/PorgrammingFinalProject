package org.reeves;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Random;

@Getter
@Setter
@EqualsAndHashCode
public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private ArrayList<Integer> scores;
    private static int nextId = 1;
    private double averageScore;

    public Assignment(String assignmentName, double weight) {
        this.assignmentId = String.format("Assignment-%d", nextId++);
        this.assignmentName = assignmentName;
        this.weight = weight;
        this.scores = new ArrayList<>();
        this.averageScore = 0.0;
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
        this.averageScore = (count == 0 ? 0.0 : (double) sum / count);
    }

    /**
     * generates random scores for all students in an assignment
     */
    public void generateRandomScore() {
        Random random = new Random();

        for (int i = 0; i < scores.size(); i++) {
            int rando = random.nextInt(11);
            int score;

            if (rando == 0) {
                score = random.nextInt(60);
            } else if (rando <= 2) {
                score = 60 + random.nextInt(10);
            } else if (rando <= 4) {
                score = 70 + random.nextInt(10);
            } else if (rando <= 8) {
                score = 80 + random.nextInt(10);
            } else {
                score = 90 + random.nextInt(11);
            }

            scores.set(i, score);
            //scores.add(score);
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
