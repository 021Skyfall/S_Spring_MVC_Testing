package IO.Testing.basic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloJUnitTest {

    @DisplayName("Hello JUnit Test")
    @Test
    public void assertionTest() {
        String expected = "Hello JUnit";
//        String actual = "Hello JUnit";
        String actual = "hello";

        assertEquals(expected,actual);
    }
}
