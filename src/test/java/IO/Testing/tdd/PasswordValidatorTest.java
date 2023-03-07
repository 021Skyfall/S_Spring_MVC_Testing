package IO.Testing.tdd;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PasswordValidatorTest {
    @Test
    @DisplayName("패스워드 유효성 검증 테스트: 모든 조건에 만족")
    @Order(0)
    public void validatePassword() {
        // given
        String password = "asd!@#123";

        // when
        PasswordValidator validator = new PasswordValidator();
        Executable executable = () -> validator.validate(password);

        // then
        assertDoesNotThrow(executable);
    }

    @Test
    @DisplayName("특수 문자 포함 안됨 테스트")
    @Order(1)
    public void validatePasswordWithoutSpecialCharacter() {
        // given
        String password = "AbcD1234";

        // when
        PasswordValidator validator = new PasswordValidator();
        Executable executable = () -> validator.validate(password);

        // then
        assertDoesNotThrow(executable);
    }
}
