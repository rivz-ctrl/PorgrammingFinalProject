import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.reeves.Address;
import org.reeves.Assignment;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class AssignmentTest {
    @Test
    @DisplayName("[70,80,90] -> 80.0")
    void testCalcAssignmentAverage1() {
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(80);
        scores.add(90);
        scores.add(70);

        Assignment assignment = new Assignment("AssignmentTest", 25);
        assignment.setScores(scores);
        assignment.calcAssignmentAvg();

        double expected = 80.0;
        double actual = assignment.getAverageScore();
        Assertions.assertEquals(expected, actual);
    }
}
