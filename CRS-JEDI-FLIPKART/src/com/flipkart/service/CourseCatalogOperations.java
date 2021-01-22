package com.flipkart.service;

import com.flipkart.bean.Course;
import org.apache.log4j.Logger;

import java.util.ArrayList;

/**
 * Course Catalog business class
 */
public class CourseCatalogOperations implements CourseCatalogInterface{
	
	private static Logger logger = Logger.getLogger(CourseCatalogOperations.class);
	
	@Override
	public void viewCatalog() {
		// TODO Auto-generated method stub
		logger.info("In fetch Catalog Details");
	}

	@Override
	public void viewCourse(int courseId) {
		// TODO Auto-generated method stub
		logger.info("In View Course");
	}
}
