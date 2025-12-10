import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.reeves.Course;
import org.reeves.Department;

public class CourseTest {

    @Test
    @DisplayName("weight1 + weight2 + weightn = 100 -> true")
    void testIsAssignmentWeightValid() {
        Department department = new Department("Finance");
        Course course = new Course(department, "Budgeting", 1.0);

        course.addAssignment("shoppingBudget", 50, 100);
        course.addAssignment("investingBudget", 50, 100);

        boolean expected = true;
        boolean actual = course.isAssignmentWeightValid();
        Assertions.assertEquals(expected, actual);
    }

}
