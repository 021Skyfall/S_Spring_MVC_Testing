package IO.Testing.basic;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class AfterAllTest {
    private static Map<String, String> map;

    @AfterAll
    public static void init() {
        map = new HashMap<>();
        map.put("XRP", "Ripple");
        map.put("ADA","Sep");

        System.out.println("initialize Crypto Currency map");
    }

    @DisplayName("Test Case 1")
    @Test
    public void beforeEachTest() {
        assertDoesNotThrow(() -> getCryptoCurrency("XRP"));
    }

    @DisplayName("Test case 2")
    @Test
    public void beforeEachTest2() {
        assertDoesNotThrow(() -> getCryptoCurrency("ADA"));
    }

    private String getCryptoCurrency(String unit) {
        return map.get(unit).toUpperCase();
    }
}
