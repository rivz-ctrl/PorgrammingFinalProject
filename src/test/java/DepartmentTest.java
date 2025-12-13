import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.reeves.Assignment;
import org.reeves.Department;

public class DepartmentTest {
    @Test
    @DisplayName("MiNIstRy of ENJOYment -> true")
    void testIsDepartmentNameValid1() {
        String str = "MiNIstRy of ENJOYment";
        boolean expected = true;
        boolean actual = Department.isDepartmentNameValid(str);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("H2O -> false")
    void testIsDepartmentNameValid2() {
        String str = "H2O";
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(str);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName(" '' -> false")
    void testIsDepartmentNameValid3() {
        String str = "";
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(str);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName(" ' ' -> false")
    void testIsDepartmentNameValid4() {
        String str = " ";
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(str);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("H2O -> false")
    void testIsDepartmentNameValid5() {
        String str = "H2O";
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(str);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName(" null -> false")
    void testIsDepartmentNameValid6() {
        String str = null;
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(str);
        Assertions.assertEquals(expected, actual);
    }
}
