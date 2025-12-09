import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.reeves.Address;

public class AddressTest {
    @Test
    @DisplayName("A1b3C3 -> true")
    void testIsPostalCodeValid1() {
        String postalCode = "A1B2C3";
        boolean expected = true;
        boolean actual = Address.isPostalCodeValid(postalCode);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName(" ' ' -> false")
    void testIsPostalCodeValid2() {
        String postalCode = " ";
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(postalCode);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName(" '' -> false")
    void testIsPostalCodeValid3() {
        String postalCode = "";
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(postalCode);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("a-1b-2c-3 -> false")
    void testIsPostalCodeValid4() {
        String postalCode = "A-1B-3C-3";
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(postalCode);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("null -> false")
    void testIsPostalCodeValid5() {
        String postalCode = null;
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(postalCode);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("a1b2 -> false")
    void testIsPostalCodeValid6() {
        String postalCode = "a1b2";
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(postalCode);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("$$$$$$ -> false")
    void testIsPostalCodeValid7() {
        String postalCode = "$$$$$$";
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(postalCode);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("a1b232 -> false")
    void testIsPostalCodeValid8() {
        String postalCode = "a1b232";
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(postalCode);
        Assertions.assertEquals(expected, actual);
    }
}
