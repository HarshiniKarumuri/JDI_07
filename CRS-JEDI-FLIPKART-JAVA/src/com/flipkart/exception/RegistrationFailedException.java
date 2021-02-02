package com.flipkart.exception;

public class RegistrationFailedException extends Exception{
    private final String email;

    // Constructor to initialize courseName
    public RegistrationFailedException(String email) {
        super();
        this.email = email;
    }

    @Override
    public String getMessage() {
        return "Error registering the user with email \"" + email + "\"\n";
    }
}
