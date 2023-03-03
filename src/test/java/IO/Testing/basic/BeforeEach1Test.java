package IO.Testing.basic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BeforeEach1Test {

    @BeforeEach
    public void init() {
        System.out.println("Pre-processing before each test case");
    }

    @DisplayName("@BeforeEach Test1")
    @Test
    public void beforeEachTest1() {

    }

    @DisplayName("@BeforeEach Test2")
    @Test
    public void beforeEachTest2() {

    }
}
