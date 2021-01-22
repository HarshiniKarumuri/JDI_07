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
	public void viewCatalog();

	
	
	/**
	 * 
	 * @param courseId unique course identifier 
	 * method used to see the course details
	 */
	public void viewCourse(int courseId);
}
