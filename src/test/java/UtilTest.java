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

    @Test
    @DisplayName("HEllo wORld -> Hello World")
    void testToTitleCase2() {
        String str = "HEllo wORld";
        String expected = "Hello World";
        String actual = Util.toTitleCase(str);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName(" '' -> '' ")
    void testToTitleCase3() {
        String str = "";
        String expected = "";
        String actual = Util.toTitleCase(str);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("hello   world -> Hello World")
    void testToTitleCase4() {
        String str = "hello   world";
        String expected = "Hello World";
        String actual = Util.toTitleCase(str);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("hello -> Hello")
    void testToTitleCase5() {
        String str = "hello";
        String expected = "Hello";
        String actual = Util.toTitleCase(str);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("2026 ain't got nun on me, NAN! -> 2026 Ain't Got Nun On Me, Nan!")
    void testToTitleCase6() {
        String str = "2026 ain't got nun on me, NAN!";
        String expected = "2026 Ain't Got Nun On Me, Nan!";
        String actual = Util.toTitleCase(str);
        Assertions.assertEquals(expected, actual);
    }
}
