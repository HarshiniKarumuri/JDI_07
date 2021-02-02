package com.flipkart.exception;

public class CourseNotAvailableException extends Exception {

    private final int courseId;

    // Constructor to initialize courseId
    public CourseNotAvailableException(int courseId) {
        super();
        this.courseId = courseId;
    }

    @Override
    public String getMessage() {
        return "Course \""+ courseId +"\" is no longer available\n";
    }
}
