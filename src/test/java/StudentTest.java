import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.reeves.*;

public class StudentTest {
    @Test
    @DisplayName("signing up for a new course -> true")
    void testRegisterCourses1() {
        Department department = new Department("Finances");
        Address address = new Address(5555, "Av. Patrice Lumumba", "Night City" ,Address.Province.ON, "W4H4L4");
        Student student = new Student("Aubrey Graham", Student.Gender.MALE, address, department);
        Course course = new Course(department, "FF101", 2.0);

        boolean expected = true;
        boolean actual = student.registerCourses(course);

        Assertions.assertEquals(expected, actual);
        Assertions.assertTrue(student.getRegisteredCourses().contains(course));
    }

    @Test
    @DisplayName("signing up for the same course twice course -> false")
    void testRegisterCourses2() {
        Department department = new Department("Finances");
        Address address = new Address(5555, "Av. Patrice Lumumba", "Night City" ,Address.Province.ON, "W4H4L4");
        Student student = new Student("Aubrey Graham", Student.Gender.MALE, address, department);
        Course course = new Course(department, "FF101", 2.0);

        student.registerCourses(course);

        boolean expected = false;
        boolean actual = student.registerCourses(course);

        Assertions.assertEquals(expected, actual);
    }
}
