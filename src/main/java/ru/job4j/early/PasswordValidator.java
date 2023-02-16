package ru.job4j.early;

public class PasswordValidator {
    public static String validate(String password) {
        boolean isUpperCase = false;
        boolean isLowerCase = false;
        boolean isDigit = false;
        boolean isSpecial = false;
        String[] substrings = {"qwerty", "12345", "password", "admin", "user"};
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        for (char p : password.toCharArray()) {
            if (Character.isUpperCase(p)) {
                isUpperCase = true;
            }
            if (Character.isLowerCase(p)) {
                isLowerCase = true;
            }
            if (Character.isDigit(p)) {
                isDigit = true;
            }
            if (!Character.isDigit(p) && !Character.isAlphabetic(p)) {
                isSpecial = true;
            }
        }
        if (!isUpperCase) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (!isLowerCase) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!isDigit) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (!isSpecial) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        for (String substring : substrings) {
            if (password.toLowerCase().contains(substring)) {
                throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
            }
        }
        return password;
    }
}
