package com.flipkart.service;

import com.flipkart.bean.Course;
import org.apache.log4j.Logger;

import java.util.ArrayList;

/**
 * Course Catalog business class
 */
public class CourseCatalogOperations implements CourseCatalogInterface{
	
	private static Logger logger = Logger.getLogger(CourseCatalogOperations.class);
	
	public void viewCatalog() {
		logger.info("In fetch Catalog Details");
	}

	public void viewCourse(int courseId) {
		logger.info("In View Course");
	}
}
