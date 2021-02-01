package com.flipkart.service;

import java.util.ArrayList;

import com.flipkart.bean.Course;

/**
 * Course Catalog business interface
 */
public interface CourseCatalogInterface {

    /**
     * to see the list of courses in the catalog
     */
    ArrayList<Course> viewCoursesCatalog();

    /**
     * method used to see the course details
     *
     * @param courseId unique course identifier
     */
    void viewCourseDetails(int courseId);

    /**
     * To view all the offered courses in the course catalog
     */
    ArrayList<Course> viewCoursesOffered();
}
