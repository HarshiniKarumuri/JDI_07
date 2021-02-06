package com.flipkart.exception;

public class AlreadyRegisteredUserException extends Exception {
    private final String email;

    // Constructor

    /**
     * @param email user email
     */
    public AlreadyRegisteredUserException(String email) {
        super();
        this.email = email;
    }

    /**
     * @return Already registered in CRS
     */
    @Override
    public String getMessage() {
        return "User with email \"" + email + "\" is already registered in CRS\n";
    }
}
