package com.flipkart.dao;

import java.util.ArrayList;

import com.flipkart.bean.Course;

public interface CatalogDAOInterface {
	
	/**
	 * to see the list of courses in the catalog 
	 */
	public ArrayList<Course> viewCatalog();

	
	
	/**
	 * 
	 * @param courseId unique course identifier 
	 * method used to see the course details
	 */
	public Course viewCourse(int courseId);
}
