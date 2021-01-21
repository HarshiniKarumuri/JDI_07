package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.User;
import com.flipkart.dao.AdminDAOOperations;

import java.util.ArrayList;

import org.apache.log4j.Logger;

/**
 * Admin business class
 */
public class AdminOperations implements AdminInterface {
	
	private static Logger logger = Logger.getLogger(AdminOperations.class);
	private final AdminDAOOperations adminDAOOperations = new AdminDAOOperations();

	public void viewUser() {
		logger.info("In viewUser");
		
		ArrayList<User> users = adminDAOOperations.viewUser();
		
		for(User user:users) {
			logger.info(String.format("UserName = %s, UserId = %d", user.getUsername(),user.getUserId()));
		}
	}
	
	public void addCourseIntoCatalog(Course course) {
		logger.info("In add Course Into Catalouge");
		
	}

	public void deleteCourse(int courseId) {
		logger.info("In delete Course");
		
	}

	public void addProfessor(Professor professor) {
		logger.info("In add Professor");
	}
	
	public void assignProfessor(Professor professor,int courseId) {
		logger.info("In assign Professor");
	}

	public void deleteUser(int userId) {
		logger.info("In delete User");
		
	}

	


}
