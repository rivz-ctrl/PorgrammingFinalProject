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
    @DisplayName("new student signing up for a course -> true")
    void testRegisterCourses1() {
        Department department = new Department("Finances");
        Address address = new Address(5555, "Av. Patrice Lumumba", "Night City" ,Address.Province.ON, "W4H4L4");
        Student student = new Student("Aubrey Graham", Student.Gender.MALE, address, department);
        Course course = new Course(department, "Budgeting", 1.0);

        boolean expected = true;
        boolean actual = course.registerStudent(student);

        Assertions.assertEquals(expected, actual);
        Assertions.assertTrue(course.getRegisteredStudents().contains(student));
    }

    @Test
    @DisplayName("signing up for the same course twice course -> false")
    void testRegisterCourses2() {
        Department department = new Department("Finances");
        Address address = new Address(5555, "Av. Patrice Lumumba", "Night City" ,Address.Province.ON, "W4H4L4");
        Student student = new Student("Aubrey Graham", Student.Gender.MALE, address, department);
        Course course = new Course(department, "Budgeting", 1.0);

        course.registerStudent(student);

        boolean expected = false;
        boolean actual = course.registerStudent(student);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("[60, 80] -> {70}")
    void testCalcStudentAverage1() {
        Department department = new Department("Finances");
        Address address = new Address(5555, "Av. Patrice Lumumba", "Night City" ,Address.Province.ON, "W4H4L4");
        Student student = new Student("Aubrey Graham", Student.Gender.MALE, address, department);
        Course course = new Course(department, "Budgeting", 1.0);

        course.registerStudent(student);
        course.addAssignment("Ass01", 50, 100);
        course.addAssignment("Ass02", 50, 100);

        course.getAssignments().get(0).getScores().set(0, 80);
        course.getAssignments().get(1).getScores().set(0, 60);

        int[] expected = {70};
        int[] actual = course.calcStudentsAverage();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName(" [null, null] -> {0}")
    void testCalcStudentAverage2() {
        Department department = new Department("Finances");
        Address address = new Address(5555, "Av. Patrice Lumumba", "Night City" ,Address.Province.ON, "W4H4L4");
        Student student = new Student("Aubrey Graham", Student.Gender.MALE, address, department);
        Course course = new Course(department, "Budgeting", 1.0);

        course.registerStudent(student);
        course.addAssignment("Ass01", 50, 100);
        course.addAssignment("Ass02", 50, 100);

        course.getAssignments().get(0).getScores().set(0, null);
        course.getAssignments().get(1).getScores().set(0, null);

        int[] expected = {0};
        int[] actual = course.calcStudentsAverage();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("[null, null, 100 ,null] -> {25}")
    void testCalcStudentAverage3() {
        Department department = new Department("Finances");
        Address address = new Address(5555, "Av. Patrice Lumumba", "Night City" ,Address.Province.ON, "W4H4L4");
        Student student = new Student("Aubrey Graham", Student.Gender.MALE, address, department);
        Course course = new Course(department, "Budgeting", 1.0);

        course.registerStudent(student);
        course.addAssignment("Ass01", 25, 100);
        course.addAssignment("Ass02", 25, 100);
        course.addAssignment("Ass03", 25, 100);
        course.addAssignment("Ass04", 25, 100);

        course.getAssignments().get(0).getScores().set(0, null);
        course.getAssignments().get(1).getScores().set(0, null);
        course.getAssignments().get(2).getScores().set(0, 100);
        course.getAssignments().get(3).getScores().set(0, null);

        int[] expected = {25};
        int[] actual = course.calcStudentsAverage();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("toSimplifiedString(courseName, studentName, studentId) -> one string ")
    void testSimplifiedString1() {
        Department department = new Department("Finances");
        Address address = new Address(5555, "Av. Patrice Lumumba", "Night City" ,Address.Province.ON, "W4H4L4");
        Student student = new Student("Aubrey Graham", Student.Gender.MALE, address, department);
        Course course = new Course(department, "FF101", 2.0);

        String expected = "Finances" + " " + "Aubrey Graham" + " " + student.getStudentId() ;
        String actual = student.toSimplifiedString();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("adds a new assignment -> true")
    void testAddAssignment1() {
        Department department = new Department("Finances");
        Address address = new Address(5555, "Av. Patrice Lumumba", "Night City" ,Address.Province.ON, "W4H4L4");
        Student student = new Student("Aubrey Graham", Student.Gender.MALE, address, department);
        Course course = new Course(department, "FF101", 2.0);

        course.registerStudent(student);

        boolean expected = true;
        boolean actual = course.addAssignment("FinalProject", 100, 100);

        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(1, course.getAssignments().size());
        Assertions.assertEquals(1, course.getAssignments().getFirst().getScores().size());
        Assertions.assertNull(course.getAssignments().getFirst().getScores().getFirst());
    }

    @Test
    @DisplayName("adds a pre existing assignment -> true")
    void testAddAssignment2() {
        Department department = new Department("Finances");
        Address address = new Address(5555, "Av. Patrice Lumumba", "Night City" ,Address.Province.ON, "W4H4L4");
        Student student = new Student("Aubrey Graham", Student.Gender.MALE, address, department);
        Course course = new Course(department, "FF101", 2.0);

        course.registerStudent(student);

        boolean firstAss = course.addAssignment("FinalProject", 100, 100);
        Assertions.assertTrue(firstAss);

        boolean secondAss = course.addAssignment("FinalProject", 100, 100);
        Assertions.assertFalse(secondAss);

        Assertions.assertEquals(1, course.getAssignments().size());
        Assertions.assertEquals(1, course.getAssignments().getFirst().getScores().size());
        Assertions.assertNull(course.getAssignments().getFirst().getScores().getFirst());

    }

}
