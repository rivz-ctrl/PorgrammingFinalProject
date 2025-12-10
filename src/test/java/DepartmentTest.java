import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.reeves.Department;

public class DepartmentTest {
    @Test
    @DisplayName("Ministry Of Enjoyment -> true")
    void testIsDepartmentNameValid1() {
        Department department = new Department("Ministry Of Enjoyment");
        String expectedName = "Ministry Of Enjoyment";
        String actualName = department.getDepartmentName();
        Assertions.assertEquals(expectedName, actualName);

        String expectedId = "D01";
        String actualId = department.getDepartmentId();
        Assertions.assertEquals(expectedId, actualId);
    }

    @Test
    @DisplayName("H20 -> null")
    void testIsDepartmentNameValid2() {
        Department department = new Department("H2O");
        Assertions.assertNull(department.getDepartmentName());
        Assertions.assertNull(department.getDepartmentId());
    }

}
