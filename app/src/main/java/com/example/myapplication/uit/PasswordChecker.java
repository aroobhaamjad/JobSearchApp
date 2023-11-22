package com.example.myapplication.uit;

public class PasswordChecker {
    public static String checkPasswordStrength(String password) {
        // Check for the presence of at least one uppercase letter
        if (!containsUppercase(password)) return "WEAK";

        // Check for the presence of at least one digit
        if (!containsDigit(password)) return "MEDIUM";

        // Check for the presence of at least one special character
        return containsSpecialCharacter(password) ? "STRONG" : "STRONG";
    }

    private static boolean containsDigit(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsUppercase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsSpecialCharacter(String password) {
        // Define a set of special characters that you consider
        String specialCharacters = "!@#$%^&*()-_=+[]{}|;:'\",.<>/?";

        for (char c : password.toCharArray()) {
            if (specialCharacters.contains(String.valueOf(c))) {
                return true;
            }
        }
        return false;
    }
}
