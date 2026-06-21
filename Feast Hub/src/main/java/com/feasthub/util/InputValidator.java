package com.feasthub.util;

public class InputValidator {
    public static boolean isValidRating(double rating) {
        return rating >= 1.0 && rating <= 5.0;
    }

    public static boolean isNotBlank(String value) {
        return value != null && !value.trim().isEmpty();
    }
}
