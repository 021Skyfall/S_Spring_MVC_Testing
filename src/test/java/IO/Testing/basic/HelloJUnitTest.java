package IO.Testing.basic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloJUnitTest {

    @Test
    @DisplayName("Hello JUnit Test")
    public void assertionTest() {
//        String actual = "Hello JUnit";
        String actual = "Hello, JUnit";
        String expected = "Hello JUnit";

//        assertEquals(actual,expected);
        assertThat(actual, is(equalTo(expected)));
    }
}
