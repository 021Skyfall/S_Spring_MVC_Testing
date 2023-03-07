package IO.Testing.tdd;

import java.util.regex.Pattern;

public class PasswordValidator {
    public void validate(String password) {
//
//        boolean containSpecialCharacter =
//                password.chars()
//                        .anyMatch(ch -> !(Character.isDigit(ch) || Character.isAlphabetic(ch)));

        if (!Pattern.matches("(?=.*\\W)(?=\\S+$).+", password)) {
            throw new RuntimeException("Invalid password");

        }
    }
}
