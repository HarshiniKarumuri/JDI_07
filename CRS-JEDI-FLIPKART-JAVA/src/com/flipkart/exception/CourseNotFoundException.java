package com.flipkart.exception;

public class CourseNotFoundException extends Exception {
    private final int courseId;

    // Constructor to initialize courseName
    public CourseNotFoundException(int courseId) {
        super();
        this.courseId = courseId;
    }

    @Override
    public String getMessage() {
        return "No course offered with provided course ID \""+courseId+"\"\n";
    }
}
