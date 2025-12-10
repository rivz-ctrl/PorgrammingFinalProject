import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.reeves.Assignment;

import java.util.ArrayList;

public class AssignmentTest {
    @Test
    @DisplayName("[70,80,90] -> 80.0")
    void testCalcAssignmentAverage1() {
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(80);
        scores.add(90);
        scores.add(70);

        Assignment assignment = new Assignment("AssignmentTest1", 25);
        assignment.setScores(scores);
        assignment.calcAssignmentAvg();

        double expected = 80.0;
        double actual = assignment.getAverageScore();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("[null] -> 0.0")
    void testCalcAssignmentAverage2() {
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(null);

        Assignment assignment = new Assignment("AssignmentTest2", 25);
        assignment.setScores(scores);
        assignment.calcAssignmentAvg();

        double expected = 0.0;
        double actual = assignment.getAverageScore();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("[] -> 0.0")
    void testCalcAssignmentAverage3() {
        ArrayList<Integer> scores = new ArrayList<>();

        Assignment assignment = new Assignment("AssignmentTest3", 25);
        assignment.setScores(scores);
        assignment.calcAssignmentAvg();

        double expected = 0.0;
        double actual = assignment.getAverageScore();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("[null, 60, 90] -> 75.0")
    void testCalcAssignmentAverage4() {
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(null);
        scores.add(60);
        scores.add((90));

        Assignment assignment = new Assignment("AssignmentTest4", 25);
        assignment.setScores(scores);
        assignment.calcAssignmentAvg();

        double expected = 75.0;
        double actual = assignment.getAverageScore();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("[100] -> 100.0")
    void testCalcAssignmentAverage5() {
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(100);

        Assignment assignment = new Assignment("AssignmentTest5", 25);
        assignment.setScores(scores);
        assignment.calcAssignmentAvg();

        double expected = 100.0;
        double actual = assignment.getAverageScore();
        Assertions.assertEquals(expected, actual);
    }
}
