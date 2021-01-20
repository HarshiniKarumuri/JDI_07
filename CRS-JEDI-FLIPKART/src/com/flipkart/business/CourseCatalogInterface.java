package com.flipkart.business;

import java.util.ArrayList;

import com.flipkart.bean.Course;

public interface CourseCatalogInterface {
	
	public ArrayList<Course> fetchCatalogDetails();
	
	public void viewCourse(int courseId);
}
