package com.flipkart.business;

import com.flipkart.bean.Course;

import java.util.ArrayList;

/**
 * Course Catalog business interface
 */
public interface CourseCatalogInterface {

	public ArrayList<Course> fetchCatalogDetails();

	public void viewCourse(int courseId);
}
