package com.flipkart.exception;

import com.flipkart.constants.UIConstants;

public class CourseNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;
    private final String courseName;

    // Constructor to initialize courseName
    public CourseNotFoundException(String courseName) {
        super();
        this.courseName = courseName;
    }

    /**
     * @return the courseName
     */
    public String getCourseName() {
        return courseName;
    }

    @Override
    public String getMessage() {
        return courseName + " - " + UIConstants.COURSE_NOT_FOUND_MESSAGE;
    }
}
