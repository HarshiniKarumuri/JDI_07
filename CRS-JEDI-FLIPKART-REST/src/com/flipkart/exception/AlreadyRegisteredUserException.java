package com.flipkart.exception;

public class AlreadyRegisteredUserException extends Exception {
    private final String email;

    // Constructor to initialize courseName
    public AlreadyRegisteredUserException(String email) {
        super();
        this.email = email;
    }

    @Override
    public String getMessage() {
        return "User with email \""+ email + "\" is already registered in CRS\n";
    }
}
