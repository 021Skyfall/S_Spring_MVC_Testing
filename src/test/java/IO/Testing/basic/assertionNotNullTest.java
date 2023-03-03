package IO.Testing.basic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class assertionNotNullTest {

    @DisplayName("AssertionNull() Test")
    @Test
    public void asserNotNullTest() {
        String currencyName = getCryptoCurrency("ETH");

        assertNotNull(currencyName, "should be not null");
    }

    private String getCryptoCurrency(String unit) {
        return CryptoCurrency.map.get(unit);
    }
}
