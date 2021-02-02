package com.flipkart.exception;

public class CourseAlreadyRegisteredException extends Exception {

    private final int courseId;

    // Constructor to initialize courseId
    public CourseAlreadyRegisteredException(int courseId) {
        super();
        this.courseId = courseId;
    }

    @Override
    public String getMessage() {
        return "The course with course ID \""+courseId+"\" is already registered by you\n";
    }
}
