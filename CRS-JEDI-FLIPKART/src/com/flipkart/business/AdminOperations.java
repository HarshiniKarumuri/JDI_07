package com.flipkart.business;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.sun.istack.internal.logging.Logger;

public class AdminOperations implements AdminInterface {
	
	private static Logger logger = Logger.getLogger(AdminOperations.class);

	public void viewCourse() {
		logger.info("In view Courses");
		return;
	}
	
	public String addCourseIntoCatalouge(Course course) {
		logger.info("In add Course Into Catalouge");
		return "";
	}
	
	public void deleteCourse(int courseId) {
		logger.info("In delete Course");
		
	}
	
	public String addProfessor(Professor professor) {
		logger.info("In add Professor");
		return "";
	}
	
	public String assignProfessor(Professor professor,int courseId) {
		logger.info("In assign Professor");
		return "";
	}
	
	public void deleteUser(int userId) {
		logger.info("In delete User");
		
	}

	
}
