package com.flipkart.exception;

import com.flipkart.constants.UIConstants;

public class CourseNotRegisteredException extends Exception {

    private static final long serialVersionUID = 1L;
    private final String courseName;

    // Constructor to initialize courseName
    public CourseNotRegisteredException(String courseName) {
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
        return UIConstants.FAILURE_COURSE_REGISTER_MESSAGE;
    }
}
