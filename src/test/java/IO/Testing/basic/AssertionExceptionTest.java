package IO.Testing.basic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class AssertionExceptionTest {

    @DisplayName("throws NullPointerException when map.get()")
    @Test
    public void assertionThrowExceptionTest() {
        assertThrows(NullPointerException.class, () -> getCrytoCurrency("XRP"));
    }

    private String getCrytoCurrency(String unit) {
        return CryptoCurrency.map.get(unit).toUpperCase();
    }
}
