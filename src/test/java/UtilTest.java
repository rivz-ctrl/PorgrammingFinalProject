import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.reeves.util.Util;

public class UtilTest {

    @Test
    @DisplayName("hello world -> Hello World")
    void testToTitleCase1() {
        String str = "hello world";
        String expected = "Hello World";
        String actual = Util.toTitleCase(str);
        Assertions.assertEquals(expected, actual);
    }
}
