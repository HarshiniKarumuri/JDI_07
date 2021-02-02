package com.flipkart.exception;

public class UserNotFoundException extends Exception {
    private final int userId;
    private final String purpose;

    // Constructor to initialize courseName
    public UserNotFoundException(int userId, String purpose) {
        super();
        this.userId = userId;
        this.purpose = purpose;
    }

    @Override
    public String getMessage() {
        return "No user with User ID \"" + userId + "\" exists to "+ purpose + "\n" ;
    }
}
