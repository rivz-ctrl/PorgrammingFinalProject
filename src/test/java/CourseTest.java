import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.reeves.Address;
import org.reeves.Course;
import org.reeves.Department;
import org.reeves.Student;

public class CourseTest {
    @Test
    @DisplayName("weight1 + weight2 + weightn = 100 -> true")
    void testIsAssignmentWeightValid1() {
        Department department = new Department("Finance");
        Course course = new Course(department, "Budgeting", 1.0);

        course.addAssignment("shoppingBudget", 50, 100);
        course.addAssignment("investingBudget", 50, 100);

        boolean expected = true;
        boolean actual = course.isAssignmentWeightValid();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("weight1 + weight2 + weightn != 100 -> false")
    void testIsAssignmentWeightValid2() {
        Department department = new Department("Finance");
        Course course = new Course(department, "Budgeting", 1.0);

        course.addAssignment("shoppingBudget", 70, 100);
        course.addAssignment("investingBudget", 50, 100);

        boolean expected = false;
        boolean actual = course.isAssignmentWeightValid();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("new student -> true")
    void testRegisterStudent1() {
        Department department = new Department("Finance");
        Course course = new Course(department, "Budgeting", 1.0);

        Address address = new Address(5555, "Av. Patrice Lumumba", "Night City" ,Address.Province.ON, "W4H4L4");
        Student student = new Student("Aubrey Graham", Student.Gender.MALE, address, department);
    }
}
