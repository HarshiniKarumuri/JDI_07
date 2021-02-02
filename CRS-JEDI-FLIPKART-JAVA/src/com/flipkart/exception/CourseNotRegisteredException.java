package com.flipkart.exception;


public class CourseNotRegisteredException extends Exception {
    private final int courseId;

    // Constructor to initialize courseId
    public CourseNotRegisteredException(int courseId) {
        super();
        this.courseId = courseId;
    }

    @Override
    public String getMessage() {
        return "The course with Course ID \""+courseId+"\" is not registered with the user";
    }
}
