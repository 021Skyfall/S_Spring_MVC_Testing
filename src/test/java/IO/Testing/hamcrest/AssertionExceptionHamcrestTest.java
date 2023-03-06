package IO.Testing.hamcrest;

import IO.Testing.basic.CryptoCurrency;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AssertionExceptionHamcrestTest {

    @Test
    @DisplayName("throws NullPointerException when map.get()")
    public void assertionThrowExceptionTest() {
        Throwable actualException = assertThrows(NullPointerException.class,
                () -> getCrytoCurrency("XRP"));

        assertThat(actualException.getClass(),is(NullPointerException.class));
    }

    private String getCrytoCurrency(String unit) {
        return CryptoCurrency.map.get(unit).toUpperCase();
    }
}
