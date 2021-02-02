package com.flipkart.exception;

public class RegistrationNotCompletedException extends Exception {
    private final String userId;

    // Constructor to initialize courseName
    public RegistrationNotCompletedException(String userId) {
        super();
        this.userId = userId;
    }

    @Override
    public String getMessage() {
        return "Registration Done. Profile not added in CRS. Please login using User ID \"" + userId + "\" and the password used during registration to complete the process\n" ;
    }
}
