package IO.Testing.hamcrest;

import IO.Testing.basic.CryptoCurrency;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AssertionNullHamcrestTest {

    @Test
    @DisplayName("AssertionNull() Test")
    public void assertNotNullTest() {
        String currencyName = getCryptoCurrency("ETH");

//        assertThat(currencyName, is(notNullValue()));
        assertThat(currencyName, is(nullValue()));
    }

    private String getCryptoCurrency(String unit) {
        return CryptoCurrency.map.get(unit);
    }
}
