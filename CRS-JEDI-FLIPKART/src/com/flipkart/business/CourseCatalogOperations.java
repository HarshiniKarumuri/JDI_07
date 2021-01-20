package com.flipkart.business;

import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.sun.istack.internal.logging.Logger;

public class CourseCatalogOperations implements CourseCatalogInterface{
	
	private static Logger logger = Logger.getLogger(CourseCatalogOperations.class);
	
	public ArrayList<Course> fetchCatalogDetails() {
		logger.info("In fetch Catalog Details");
		return null;
	}
	
	public void viewCourse(int courseId) {
		logger.info("In View Course");
	}
}
