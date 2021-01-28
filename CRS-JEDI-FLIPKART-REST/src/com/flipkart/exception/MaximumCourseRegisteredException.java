package com.flipkart.exception;

import com.flipkart.constants.UIConstants;

public class MaximumCourseRegisteredException extends Exception {

    private static final long serialVersionUID = 1L;

    @Override
    public String getMessage() {
        return UIConstants.MAX_LIMIT_REACHED_MESSAGE;
    }

}
