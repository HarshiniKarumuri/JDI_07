package com.flipkart.service;

import com.flipkart.bean.Course;

import java.util.ArrayList;

/**
 * Course Catalog business interface
 */
public interface CourseCatalogInterface {

	/**
	 * to see the list of courses in the catalog 
	 */
	void viewCoursesCatalog();

	/**
	 * 
	 * @param courseId unique course identifier 
	 * method used to see the course details
	 */
	void viewCourseDetails(int courseId);
	
	/**
     * To view all the offered courses in the course catalog
     */
    void viewCoursesOffered();
}
