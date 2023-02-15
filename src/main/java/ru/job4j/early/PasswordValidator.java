package ru.job4j.early;

public class PasswordValidator {
    public static String validate(String password) {
        String special = "~`!@#$%^&*()-_=+\\|[{]};:'\",<.>/?";
        int count;
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        count = password.length();
        for (char p : password.toCharArray()) {
            if (!Character.isUpperCase(p)) {
                count--;
                if (count == 0) {
                    throw new IllegalArgumentException("Password should contain at least one uppercase letter");
                }
            }
        }
        count = password.length();
        for (char p : password.toCharArray()) {
            if (!Character.isLowerCase(p)) {
                count--;
                if (count == 0) {
                    throw new IllegalArgumentException("Password should contain at least one lowercase letter");
                }
            }
        }
        count = password.length();
        for (char p : password.toCharArray()) {
            if (!Character.isDigit(p)) {
                count--;
                if (count == 0) {
                    throw new IllegalArgumentException("Password should contain at least one figure");
                }
            }
        }
        count = password.length();
        for (char p : password.toCharArray()) {
            if (!special.contains(String.valueOf(p))) {
                count--;
                if (count == 0) {
                    throw new IllegalArgumentException("Password should contain at least one special symbol");
                }
            }
        }
        if (password.toLowerCase().contains("qwerty") || password.toLowerCase().contains("12345")
                || password.toLowerCase().contains("password") || password.toLowerCase().contains("admin")
                || password.toLowerCase().contains("user")) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }
        return password;
    }
}
