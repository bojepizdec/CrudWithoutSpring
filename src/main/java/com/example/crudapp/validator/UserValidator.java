package com.example.crudapp.validator;

import com.example.crudapp.model.User;


public class UserValidator {

    public static boolean isValidName(String name) {
        return name != null && name.length() >= 2 && name.length() <= 50;
    }

    public static boolean isValidEmail(String email) {
        return email != null && email.matches("^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$");
    }
     public static void validate(User user) throws IllegalArgumentException {
        if (!isValidName(user.getName())) {
            throw new IllegalArgumentException("Username is invalid. Username must be between 2 and 50 characters.");
        }
        if (!isValidEmail(user.getEmail())) {
            throw new IllegalArgumentException("Email is invalid. Set a valid email address.");
        }
     }
}
