package com.flipkart.service;

import com.flipkart.bean.Course;

import org.apache.log4j.Logger;

import java.util.ArrayList;

/**
 * Course Catalog business class
 */
public class CourseCatalogOperations implements CourseCatalogInterface{
	
	private static Logger logger = Logger.getLogger(CourseCatalogOperations.class);
	
	private static volatile CourseCatalogOperations instance = null;
	
	private CourseCatalogOperations() {
    }
 
    public static CourseCatalogOperations getInstance() {
        if (instance == null) {
        	// This is a synchronized block, when multiple threads will access this instance
            synchronized (CourseCatalogOperations.class) {
                instance = new CourseCatalogOperations();
            }
        }
        return instance;
    }
	
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
