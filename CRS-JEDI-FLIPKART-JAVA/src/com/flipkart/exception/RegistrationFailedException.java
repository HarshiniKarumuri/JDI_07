package com.flipkart.exception;


public class RegistrationFailedException extends Exception {
    private final String email;

    // Constructor

    /**
     * @param email user email
     */
    public RegistrationFailedException(String email) {
        super();
        this.email = email;
    }

    /**
     * @return Error registering the user
     */
    @Override
    public String getMessage() {
        return "Error registering the user with email \"" + email + "\"\n";
    }
}
